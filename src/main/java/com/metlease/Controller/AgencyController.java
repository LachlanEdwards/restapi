package com.metlease.Controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.metlease.Entity.Agency;
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
@RequestMapping("/agency")
public class AgencyController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}", produces = "application/json")
    public Agency getAgency(@PathVariable("id") int id) {
        return null;
    }
}