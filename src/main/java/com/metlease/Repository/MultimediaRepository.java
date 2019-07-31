package com.metlease.Repository;
import com.metlease.Entity.ForLease;
import com.metlease.Entity.Multimedia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MultimediaRepository extends JpaRepository<Multimedia, Integer>, JpaSpecificationExecutor {
    @Query(value = "SELECT * FROM Multimedia WHERE building_id = ?1", nativeQuery = true)
    Page<Multimedia> findByBuildingId(int id, Pageable pageable);
}