package com.metlease.Service;

import com.metlease.Entity.*;
import com.metlease.Entity.Helpers.Mean;
import com.metlease.Repository.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private MultimediaRepository multimediaRepository;

    public Optional<Building> getById(int id) {
        return buildingRepository.findById(id);
    }

    public List<ForLease> getForLease(int id, int page) {
        Pageable defaultPagination = PageRequest.of(page, 12);
        return forLeaseRepository.findByBuildingId(id, defaultPagination);
    }

/*    public Integer getRankingBy(int id, String by) {
        return buildingRepository.getRankingBy(id, by);
    }*/

    public Page<ForLease> getForLeaseBy(int id, int page, Optional<Integer> bed, Optional<Integer> bath, Optional<Integer> garage, Optional<Integer> price) {
        Pageable defaultPagination = PageRequest.of(page, 12);
        return forLeaseRepository.findAll(ForTypeSpecification.findAllForTypeByParam(id, bed, bath, garage, price), defaultPagination);
    }

    public Page<ForSale> getForSaleBy(int id, int page, Optional<Integer> bed, Optional<Integer> bath, Optional<Integer> garage, Optional<Integer> price) {
        Pageable defaultPagination = PageRequest.of(page, 12);
        return forSaleRepository.findAll(ForTypeSpecification.findAllForTypeByParam(id, bed, bath, garage, price), defaultPagination);
    }

   public Page<BuildingReview> getBuildingReviewBy(int id, int page, Optional<Integer> score) {
        Pageable defaultPagination = PageRequest.of(page, 10);
        return buildingReviewRepository.findByBuildingIdAndScore(id, score, defaultPagination);
    }

    public Page<BuildingReview> getBuildingReviewsById(int building_id, int page) {
        Pageable defaultPagination = PageRequest.of(page, 12);
        return buildingReviewRepository.findByBuildingId(building_id, defaultPagination);
    }

    public BuildingReview getBuildingReviewByBuildingIdAndUserId(int building_id, int user_id) {
        return buildingReviewRepository.findFirstByBuildingIdAndUserId(building_id, user_id);
    }

    public Double getBuildingMean(int id) {
        return buildingReviewRepository.findMeanReviewScore(id);
    }

    public Page<BlogPost> getBlogPostByBuildingId(int building_id, int page) {
        Pageable defaultPagination = PageRequest.of(page, 12);
        return blogRepository.findByBuildingId(building_id, defaultPagination);
    }

    public Page<Multimedia> getMultimediaByBuildingId(int building_id, int page) {
        Pageable defaultPagination = PageRequest.of(page, 12);
        return multimediaRepository.findByBuildingId(building_id, defaultPagination);
    }

    public void insertMultimediaByBuildingId(Multimedia multimedia) {
        multimedia.setDate(new Date());
        multimediaRepository.save(multimedia);
    }

    @Transactional
    public void insertBuilding(Building building) {
        buildingRepository.save(building);
    }

    @Transactional
    public void insertBuildingReviewByBuildingId(int building_id, int user_id, int score, String comment) {
        Date date = new Date();
        buildingReviewRepository.insertByBuildingId(building_id, user_id, date, score, comment);
    }

    @Transactional
    public void insertBlogPostByBuildingId(int building, String title, String body) {
        Date date = new Date();
        blogRepository.insertByBuilding(building, title, body, date);
    }
}
