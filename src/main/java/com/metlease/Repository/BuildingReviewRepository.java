package com.metlease.Repository;
import com.metlease.Entity.BuildingReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BuildingReviewRepository extends JpaRepository<BuildingReview, Integer> {
    Page<BuildingReview> findByBuildingId(int id, Pageable page);
    Page<BuildingReview> findByBuildingIdAndAggregate(int id, int aggregate, Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO Building_Reviews (building_id, user_id, date, aggregate, management, functionality, facilities, neighbourhood, culture, fittings, noise, comment) VALUES (:building_id, :user_id, :date, :aggregate, :management, :functionality, :facilities, :neighbourhood, :culture, :fittings, :noise, :comment)", nativeQuery = true)
    void insertByBuildingId(@Param("building_id") int building_id, @Param("user_id") int user_id, @Param("date") Date date, @Param("aggregate") int aggregate, @Param("management") int management, @Param("functionality") int functionality, @Param("facilities") int facilities, @Param("neighbourhood") int neighbourhood, @Param("culture") int culture, @Param("fittings") int fittings, @Param("noise") int noise, @Param("comment") String comment);
}