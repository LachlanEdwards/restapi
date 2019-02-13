package com.metlease.Controller;

import com.metlease.Entity.User;
import com.metlease.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping("/ad")
public class AdController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET, value = "/agency", produces = "application/json")
    public User getAdAgency() {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/agent", produces = "application/json")
    public User getAdAgent() {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/apartment", produces = "application/json")
    public User getAdApartment() {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/building", produces = "application/json")
    public User getAdBuilding() {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/developer", produces = "application/json")
    public User getAdDeveloper() {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/management", produces = "application/json")
    public User getAdManagement() {
        return null;
    }
}
