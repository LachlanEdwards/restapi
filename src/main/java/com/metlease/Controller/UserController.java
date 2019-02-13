package com.metlease.Controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.metlease.Entity.ApplicationUser;
import com.metlease.Entity.User;
import com.metlease.Service.UserService;
import com.metlease.Entity.Helpers.BearerTokenParser;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.metlease.Config.ConfigConstants.HEADER_STRING;
import static com.metlease.Config.ConfigConstants.SECRET;
import static com.metlease.Config.ConfigConstants.TOKEN_PREFIX;
import com.metlease.Repository.ApplicationUserRepository;

@RestController
@Scope("prototype")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    BearerTokenParser bearerTokenParser;

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}", produces = "application/json")
    public Optional<User> getUser(@PathVariable("id") int uid) {
        Optional<User> user = service.getById(uid);
        return user;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/set/{criteria}", produces = "application/json")
    public Iterable<User> getUsers(@PathVariable("criteria") String criteria) {
        Iterable<User> users = service.getByCriteria(criteria);
        return users;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/self", produces = "application/json")
    public ApplicationUser getSelf(@RequestHeader(HEADER_STRING) String token) {
        ApplicationUser user = bearerTokenParser.Parse(token);
        return user;
    }
}
