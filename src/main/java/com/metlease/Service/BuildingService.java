package com.metlease.Service;

import com.metlease.Entity.Building;
import com.metlease.Entity.ForLease;
import com.metlease.Entity.ForSale;
import com.metlease.Repository.BuildingRepository;
import com.metlease.Repository.ForLeaseRepository;
import com.metlease.Repository.ForSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.metlease.Specifications.ForTypeSpecification;

@Service
@Scope("prototype")
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private ForLeaseRepository forLeaseRepository;
    @Autowired
    private ForSaleRepository forSaleRepository;

    public Optional<Building> getById(int id) {
        return buildingRepository.findById(id);
    }

    public List<ForLease> getForLease(int id) {
        return forLeaseRepository.findByBuildingId(id);
    }

    public List<ForLease> getForLeaseBy(int id, Optional<Integer> bed, Optional<Integer> bath, Optional<Integer> garage, Optional<Integer> price) {
        return forLeaseRepository.findAll(ForTypeSpecification.findAllForTypeByParam(id, bed, bath, garage, price));
    }

    public List<ForSale> getForSaleBy(int id, Optional<Integer> bed, Optional<Integer> bath, Optional<Integer> garage, Optional<Integer> price) {
        return forSaleRepository.findAll(ForTypeSpecification.findAllForTypeByParam(id, bed, bath, garage, price));
    }
}
