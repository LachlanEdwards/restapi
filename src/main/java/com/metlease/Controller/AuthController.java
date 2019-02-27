package com.metlease.Controller;

import com.metlease.Entity.ApplicationUser;
import com.metlease.Repository.ApplicationUserRepository;
import com.metlease.Service.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.metlease.Config.ConfigConstants.HEADER_STRING;
import static com.metlease.Config.ConfigConstants.SECRET;
import static com.metlease.Config.ConfigConstants.TOKEN_PREFIX;

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
    public String authenticated() {
        return "NOT OK. Authenticated User not present. Present a Bearer Token to authorise the API.";
    }

}
