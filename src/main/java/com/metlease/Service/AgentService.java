package com.metlease.Service;

import com.metlease.Entity.Agency;
import com.metlease.Entity.Agent;
import com.metlease.Repository.AgencyRepository;
import com.metlease.Repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope("prototype")
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    public Optional<Agent> getById(int uid) {
        return agentRepository.findById(uid);
    }

    public Iterable<Agent> getByCriteria(String criteria) {
        return agentRepository.findAll();
    }
}
