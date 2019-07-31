package com.metlease.Repository;
import com.metlease.Entity.BlogPost;
import com.metlease.Entity.Building;
import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface BlogRepository extends CrudRepository<BlogPost, Integer> {
    Page<BlogPost> findByBuildingId(int building_id, Pageable page);

    @Modifying
    @Query(value = "INSERT INTO Building_Reviews (building_id, title, body, date) VALUES (:building_id, :title, :body, :date)", nativeQuery = true)
    void insertByBuilding(@Param("building_id") int building_id, @Param("title") String title, @Param("body") String body, @Param("date") Date date);
}