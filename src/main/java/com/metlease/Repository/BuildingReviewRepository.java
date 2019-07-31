package com.metlease.Repository;
import com.metlease.Entity.BuildingReview;
import com.metlease.Entity.Helpers.Mean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BuildingReviewRepository extends JpaRepository<BuildingReview, Integer>, JpaSpecificationExecutor {
    Page<BuildingReview> findByBuildingId(int id, Pageable page);
    Page<BuildingReview> findByBuildingIdAndScore(int building_id, Optional<Integer> score, Pageable pageable);
    Page<BuildingReview> findByUserId(int user_id, Pageable pageable);
    BuildingReview findFirstByBuildingIdAndUserId(int building_id, int user_id);

    @Query(value = "SELECT COALESCE(AVG(Reviews.score), 0) FROM Reviews WHERE building_id = ?1", nativeQuery = true)
    Double findMeanReviewScore(int building_id);

    @Modifying
    @Query(value = "INSERT INTO Reviews (building_id, user_id, date, score, comment) VALUES (:building_id, :user_id, :date, :score, :comment)", nativeQuery = true)
    void insertByBuildingId(@Param("building_id") int building_id, @Param("user_id") int user_id, @Param("date") Date date, @Param("score") Integer score, @Param("comment") String comment);
}