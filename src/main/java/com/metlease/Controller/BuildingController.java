package com.metlease.Controller;

import com.metlease.Entity.*;
import com.metlease.Entity.Helpers.BearerTokenParser;
import com.metlease.Entity.Helpers.StreetAddress;
import com.metlease.Exceptions.ResourceNotFoundException;
import com.metlease.Repository.ApplicationUserRepository;
import com.metlease.Repository.MultimediaRepository;
import com.metlease.Repository.UserRepository;
import com.metlease.Service.BuildingService;
import com.metlease.Service.MapboxService;
import com.metlease.Entity.Helpers.MultimediaSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.util.*;

@RestController
@Scope("prototype")
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingService service;

    @Autowired
    private MapboxService mapboxService;

    @Autowired
    BearerTokenParser bearerTokenParser;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}", produces = "application/json")
    public Optional<Building> getBuilding(@PathVariable("id") int uid) {
        Optional<Building> building = service.getById(uid);
        if (building.isPresent()) {
            building.get().setMean(service.getBuildingMean(building.get().getId()));
            return building;
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/new")
    public ResponseEntity insertBuilding(@AuthenticationPrincipal String username, @RequestBody @Valid Building building) {
        int userDetailsId = applicationUserRepository.findByUsername(username).getId();
        try {
            Building entry = building;

            entry.setAdmin(userDetailsId);

            StreetAddress streetAddress = building.getAddress();
            String[] cd = mapboxService.getMapboxResponse(String.format("%s %s %s %s %s %s", streetAddress.getNumber(), streetAddress.getStreetName(), streetAddress.getSuffix().toString(), streetAddress.getSuburb(), streetAddress.getState().toString(), streetAddress.getPostCode()));
            entry.setLongitude(cd[0]);
            entry.setLatitude(cd[1]);

            service.insertBuilding(entry);
            return ResponseEntity.status(HttpStatus.OK).body(building);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);

        }

    }


    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}/blog", produces = "application/json")
    public Page<BlogPost> getBlogPosts(@PathVariable("id") int building_id, @RequestParam(value = "page") int page) {
        Page<BlogPost> rs = service.getBlogPostByBuildingId(building_id, page);
        return rs;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}/multimedia", produces = "application/json")
    public Page<Multimedia> getMultimedia(@PathVariable("id") int building_id, @RequestParam(value = "page") int page) {
        Page<Multimedia> rs = service.getMultimediaByBuildingId(building_id, page);
        return rs;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/id/{id}/multimedia", produces = "application/json")
    public ResponseEntity uploadMultimedia(@PathVariable("id") int building_id, @RequestParam("file") List<MultipartFile> multipartFiles) {
        try {
            ArrayList<Map> mapArrayList = new ArrayList<Map>();
            for (MultipartFile multipartFile : multipartFiles) {
                File file = File.createTempFile("TEMP-", String.format("-ID%s", building_id));
                multipartFile.transferTo(file);
                Map response = MultimediaSingleton.getInstance().upload(file);

                Multimedia multimedia = new Multimedia();
                multimedia.setBuildingId(building_id);
                multimedia.setPublicId(response.get("public_id").toString());
                multimedia.setUrl(response.get("secure_url").toString());
                service.insertMultimediaByBuildingId(multimedia);

                mapArrayList.add(response);
            }

            return ResponseEntity.status(HttpStatus.OK).body(mapArrayList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
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


    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}/reviews/me", produces = "application/json")
    public BuildingReview getReviews(@AuthenticationPrincipal String username, @PathVariable("id") int uid) {
        User userDetails = userRepository.findByUsername(username).get();
        BuildingReview rs = service.getBuildingReviewByBuildingIdAndUserId(uid, userDetails.getId());
        return rs;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}/reviews", produces = "application/json")
    public Page<BuildingReview> getReviews(@PathVariable("id") int uid, @RequestParam(value = "page") int page, @RequestParam(value = "score") Optional<Integer> score) {
        if (score.isPresent()) {
            Page<BuildingReview> rs = service.getBuildingReviewBy(uid, page, score);
            return rs;
        } else {
            Page<BuildingReview> rs = service.getBuildingReviewsById(uid, page);
            return rs;
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/id/{id}/reviews/new")
    public ResponseEntity insertBuildingReview(@AuthenticationPrincipal String username, @PathVariable("id") int uid, @RequestBody BuildingReviewPayload buildingReviewPayload) {
        int userDetailsId = applicationUserRepository.findByUsername(username).getId();
        try {
            service.insertBuildingReviewByBuildingId(uid, userDetailsId, buildingReviewPayload.getScore(), buildingReviewPayload.getComment());
            return ResponseEntity.status(HttpStatus.OK).body(buildingReviewPayload);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());

        }

    }
}
