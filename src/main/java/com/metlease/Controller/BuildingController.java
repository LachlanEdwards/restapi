package com.metlease.Controller;

import com.metlease.Config.ApplicationUserDetails;
import com.metlease.Entity.*;
import com.metlease.Entity.Helpers.BearerTokenParser;
import com.metlease.Repository.ApplicationUserRepository;
import com.metlease.Service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Scope("prototype")
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingService service;

    @Autowired
    BearerTokenParser bearerTokenParser;


    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}", produces = "application/json")
    public Optional<Building> getBuilding(@PathVariable("id") int uid) {
        Optional<Building> building = service.getById(uid);
        return building;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}/lease/all", produces = "application/json")
    public List<ForLease> getAllForLeaseApartments(@PathVariable("id") int uid, @RequestParam(value = "page") int page) {
        List<ForLease> rs = service.getForLease(uid, page);
        return rs;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}/lease", produces = "application/json")
    public Page<ForLease> getForLeaseApartments(@PathVariable("id") int uid, @RequestParam(value = "page") int page, @RequestParam(value = "bedroom") Optional<Integer> bed, @RequestParam(value = "bathroom") Optional<Integer> bath, @RequestParam(value = "parking") Optional<Integer> garage, @RequestParam(value = "price") Optional<Integer> price) {
        Page<ForLease> rs = service.getForLeaseBy(uid, page, bed, bath, garage, price);
        return rs;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}/sale", produces = "application/json")
    public Page<ForSale> getForSaleApartments(@PathVariable("id") int uid, @RequestParam(value = "page") int page, @RequestParam(value = "bedroom") Optional<Integer> bed, @RequestParam(value = "bathroom") Optional<Integer> bath, @RequestParam(value = "parking") Optional<Integer> garage, @RequestParam(value = "price") Optional<Integer> price) {
        Page<ForSale> rs = service.getForSaleBy(uid, page, bed, bath, garage, price);
        return rs;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}/reviews", produces = "application/json")
    public Page<BuildingReview> getReviews(@PathVariable("id") int uid, @RequestParam(value = "page") int page, @RequestParam(value = "aggregate") Optional<Integer> aggregate) {
        if (aggregate.isPresent()) {
            Page<BuildingReview> rs = service.getBuildingReviewBy(uid, page, aggregate);
            return rs;
        } else {
            Page<BuildingReview> rs = service.getBuildingReviewsById(uid, page);
            return rs;
        }
    }
    @RequestMapping(method = RequestMethod.POST, value = "/id/{id}/reviews/new")
    public String insertBuildingReview(@AuthenticationPrincipal String username, @PathVariable("id") int uid, @RequestBody BuildingReviewPayload buildingReviewPayload) {
        int userDetailsId = applicationUserRepository.findByUsername(username).getId();

        int management = buildingReviewPayload.getManagement();
        int functionality = buildingReviewPayload.getFunctionality();
        int facilities = buildingReviewPayload.getFacilities();
        int neighbourhood = buildingReviewPayload.getNeighbourhood();
        int culture = buildingReviewPayload.getCulture();
        int fittings = buildingReviewPayload.getFittings();
        int noise = buildingReviewPayload.getNoise();

        int aggregate = aggregateAlgorithm(management, functionality, facilities, neighbourhood, culture, fittings, noise);
        service.insertBuildingReviewByBuildingId(uid, userDetailsId, aggregate, management, functionality, facilities, neighbourhood, culture, fittings, noise, buildingReviewPayload.getComment());
        return "OK. User ID " + userDetailsId + " assigned to review.";

    }

    public int aggregateAlgorithm(int management, int functionality, int facilities, int neighbourhood, int culture, int fittings, int noise) {
        int[] scores = { management, functionality, facilities, neighbourhood, culture, fittings, noise };
        int sum = 0;

        for (int i = 0; i < scores.length; i++) {
            sum = sum + scores[i];
        }
        return sum / scores.length;
    }
}
