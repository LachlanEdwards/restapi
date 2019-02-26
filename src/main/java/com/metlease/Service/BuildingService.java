package com.metlease.Service;

import com.metlease.Entity.Building;
import com.metlease.Entity.BuildingReview;
import com.metlease.Entity.ForLease;
import com.metlease.Entity.ForSale;
import com.metlease.Repository.BuildingRepository;
import com.metlease.Repository.BuildingReviewRepository;
import com.metlease.Repository.ForLeaseRepository;
import com.metlease.Repository.ForSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.metlease.Specifications.ForTypeSpecification;
import org.springframework.transaction.annotation.Transactional;

@Service
@Scope("prototype")
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private ForLeaseRepository forLeaseRepository;
    @Autowired
    private ForSaleRepository forSaleRepository;
    @Autowired
    private BuildingReviewRepository buildingReviewRepository;

    public Optional<Building> getById(int id) {
        return buildingRepository.findById(id);
    }

    public List<ForLease> getForLease(int id, int page) {
        Pageable defaultPagination = PageRequest.of(page, 10);
        return forLeaseRepository.findByBuildingId(id, defaultPagination);
    }

    public Page<ForLease> getForLeaseBy(int id, int page, Optional<Integer> bed, Optional<Integer> bath, Optional<Integer> garage, Optional<Integer> price) {
        Pageable defaultPagination = PageRequest.of(page, 10);
        return forLeaseRepository.findAll(ForTypeSpecification.findAllForTypeByParam(id, bed, bath, garage, price), defaultPagination);
    }

    public Page<ForSale> getForSaleBy(int id, int page, Optional<Integer> bed, Optional<Integer> bath, Optional<Integer> garage, Optional<Integer> price) {
        Pageable defaultPagination = PageRequest.of(page, 10);
        return forSaleRepository.findAll(ForTypeSpecification.findAllForTypeByParam(id, bed, bath, garage, price), defaultPagination);
    }

    public Page<BuildingReview> getBuildingReviewBy(int id, int page, Optional<Integer> aggregate) {
        Pageable defaultPagination = PageRequest.of(page, 10);
        return buildingReviewRepository.findByBuildingIdAndAggregate(id, aggregate.get(), defaultPagination);
    }

    public Page<BuildingReview> getBuildingReviewsById(int id, int page) {
        Pageable defaultPagination = PageRequest.of(page, 10);
        return buildingReviewRepository.findByBuildingId(id, defaultPagination);
    }

    @Transactional
    public void insertBuildingReviewByBuildingId(int building_id, int user_id, int aggregate, int management, int functionality, int facilities, int neighbourhood, int culture, int fittings, int noise, String comment) {
        Date date = new Date();
        buildingReviewRepository.insertByBuildingId(building_id, user_id, date, aggregate, management, functionality, facilities, neighbourhood, culture, fittings, noise, comment);
    }
}
