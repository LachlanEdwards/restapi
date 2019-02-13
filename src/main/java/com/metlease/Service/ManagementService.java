package com.metlease.Service;

import com.metlease.Entity.Management;
import com.metlease.Repository.ManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope("prototype")
public class ManagementService {

    @Autowired
    private ManagementRepository managementRepository;

    public Optional<Management> getById(int uid) {
        return managementRepository.findById(uid);
    }

    public Iterable<Management> getByCriteria(String criteria) {
        return managementRepository.findAll();
    }
}
