package com.metlease.Controller;

import com.metlease.Entity.StandardEntity;
import com.metlease.Service.BuildingService;
import com.metlease.Service.MapboxService;
import com.metlease.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping("/co")
public class CoController {

    @Autowired
    private MapboxService service;

    @RequestMapping(method = RequestMethod.GET, value = "/q/{q}", produces = "application/json")
    public String[] getQuery(@PathVariable("q") String q) {
        String[] response = service.getMapboxResponse(q);
        System.out.println(response);
        return response;
    }
}