package com.metlease.Service;

import com.metlease.Entity.Developer;
import com.metlease.Repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope("prototype")
public class DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    public Optional<Developer> getById(int uid) {
        return developerRepository.findById(uid);
    }

    public Iterable<Developer> getByCriteria(String criteria) {
        return developerRepository.findAll();
    }
}
