package com.metlease.Controller;

import com.metlease.Entity.ApplicationUser;
import com.metlease.Entity.Helpers.HTTP.Error;
import com.metlease.Entity.Helpers.HTTP.Error401;
import com.metlease.Repository.ApplicationUserRepository;
import com.metlease.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@Scope("prototype")

@CrossOrigin
@RequestMapping("/secure")
public class AuthController {

    @Autowired
    private UserService service;

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthController(ApplicationUserRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/create")
    public void createUser(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
    public Error authenticated() {
        return new Error401();
    }

}
