package com.metlease.Controller;

import com.metlease.Entity.Building;
import com.metlease.Entity.StandardEntity;
import com.metlease.Entity.User;
import com.metlease.Service.BuildingService;
import com.metlease.Service.NewsService;
import com.metlease.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@Scope("prototype")
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService service;
    @Autowired
    private BuildingService buildingService;

    @RequestMapping(method = RequestMethod.GET, value = "/q/{q}", produces = "application/json")
    public String getQuery(@PathVariable("q") String q) {
        String response = service.getGAPIResponse(q);
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{type}/{id}", produces = "application/json")
    public String getQueryById(@PathVariable("id") int id, @PathVariable("type") String type) {
        StandardEntity entity = null;
        String res = null;
        if (type.equals("b")) {
            entity = buildingService.getById(id).get();
            System.out.println(entity.getName() + " " + entity.getAddress().getSuburb());
            res = service.getGAPIResponse(entity.getName() + " " + entity.getAddress().getSuburb());
            return res;
        }

        return res;
    }
}