package com.metlease.Service;

import com.metlease.Entity.Contractor;
import com.metlease.Repository.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope("prototype")
public class ContractorService {

    @Autowired
    private ContractorRepository contractorRepository;

    public Optional<Contractor> getById(int uid) {
        return contractorRepository.findById(uid);
    }

    public Iterable<Contractor> getByCriteria(String criteria) {
        return contractorRepository.findAll();
    }
}
