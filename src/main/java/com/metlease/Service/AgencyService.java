package com.metlease.Service;

import com.metlease.Entity.Agency;
import com.metlease.Repository.AgencyRepository;
import com.metlease.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope("prototype")
public class AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

    public Optional<Agency> getById(int uid) {
        return agencyRepository.findById(uid);
    }

    public Iterable<Agency> getByCriteria(String criteria) {
        return agencyRepository.findAll();
    }
}
