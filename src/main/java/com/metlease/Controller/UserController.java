package com.metlease.Controller;

import com.metlease.Entity.ApplicationUser;
import com.metlease.Entity.Helpers.HTTP.Error401;
import com.metlease.Entity.User;
import com.metlease.Exceptions.DuplicateException;
import com.metlease.Repository.UserRepository;
import com.metlease.Service.UserService;
import com.metlease.Entity.Helpers.BearerTokenParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.metlease.Config.ConfigConstants.HEADER_STRING;
import com.metlease.Repository.ApplicationUserRepository;

@RestController
@Scope("prototype")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    BearerTokenParser bearerTokenParser;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}", produces = "application/json")
    public Optional<User> getUser(@PathVariable("id") int uid) {
        Optional<User> user = service.getById(uid);
        return user;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/self/update", produces = "application/json")
    public Object updateUser(@AuthenticationPrincipal String username, @RequestBody ApplicationUser user) throws DuplicateException {
        User userDetails = userRepository.findByUsername(username).get();
        if (userDetails.getId() != user.getId()) {
            return new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED);
        } else if (userRepository.findByUsername(user.getUsername()).isPresent() && !username.equals(user.getUsername())) {
            return new HttpStatusEntryPoint(HttpStatus.IM_USED);
        } else {
            User updateUser = userDetails;
            updateUser.setUsername(user.getUsername());
            updateUser.setMail(user.getMail());
            updateUser.setGender(user.getGender());
            updateUser.setPhone(user.getPhone());
            updateUser.setBirthday(user.getBirthday());
            return service.updateUser(updateUser, userDetails.getId());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/self", produces = "application/json")
    public ApplicationUser getSelf(@RequestHeader(HEADER_STRING) String token) {
        ApplicationUser user = bearerTokenParser.Parse(token);
        return user;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/comments", produces = "application/json")
    public ApplicationUser getComments(@RequestHeader(HEADER_STRING) String token) {
        ApplicationUser user = bearerTokenParser.Parse(token);
        return user;
    }
}
