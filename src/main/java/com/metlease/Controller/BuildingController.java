package com.metlease.Controller;

import com.metlease.Entity.Building;
import com.metlease.Entity.ForLease;
import com.metlease.Entity.ForSale;
import com.metlease.Entity.Helpers.BearerTokenParser;
import com.metlease.Service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.metlease.Config.ConfigConstants.HEADER_STRING;

@RestController
@Scope("prototype")
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingService service;

    @Autowired
    BearerTokenParser bearerTokenParser;

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}", produces = "application/json")
    public Optional<Building> getBuilding(@PathVariable("id") int uid) {
        Optional<Building> building = service.getById(uid);
        return building;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}/lease/all", produces = "application/json")
    public List<ForLease> getAllForLeaseApartments(@PathVariable("id") int uid) {
        List<ForLease> rs = service.getForLease(uid);
        return rs;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}/lease", produces = "application/json")
    public List<ForLease> getForLeaseApartments(@PathVariable("id") int uid, @RequestParam(value = "bedroom") Optional<Integer> bed, @RequestParam(value = "bathroom") Optional<Integer> bath, @RequestParam(value = "parking") Optional<Integer> garage, @RequestParam(value = "price") Optional<Integer> price) {
        List<ForLease> rs = service.getForLeaseBy(uid, bed, bath, garage, price);
        return rs;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}/sale", produces = "application/json")
    public List<ForSale> getForSaleApartments(@PathVariable("id") int uid, @RequestParam(value = "bedroom") Optional<Integer> bed, @RequestParam(value = "bathroom") Optional<Integer> bath, @RequestParam(value = "parking") Optional<Integer> garage, @RequestParam(value = "price") Optional<Integer> price) {
        List<ForSale> rs = service.getForSaleBy(uid, bed, bath, garage, price);
        return rs;
    }
}
