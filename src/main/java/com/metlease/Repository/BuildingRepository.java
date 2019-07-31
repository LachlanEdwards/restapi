package com.metlease.Repository;
import com.metlease.Entity.Building;
import com.metlease.Entity.BuildingReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface BuildingRepository extends CrudRepository<Building, Integer> {
}