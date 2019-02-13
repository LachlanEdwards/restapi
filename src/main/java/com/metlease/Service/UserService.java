package com.metlease.Service;

import com.metlease.Entity.ApplicationUser;
import com.metlease.Entity.User;
import com.metlease.Exceptions.SIDException;
import com.metlease.Repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.metlease.Repository.UserRepository;
import com.metlease.Entity.User;

import java.util.List;
import java.util.Optional;

@Service
@Scope("prototype")
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    public Optional<User> getById(int uid) {
        return userRepository.findById(uid);
    }

    public ApplicationUser getByUsername(String username) {
        return applicationUserRepository.findByUsername(username);
    }

    public Iterable<User> getByCriteria(String criteria) {
        return userRepository.findAll();
    }
}
