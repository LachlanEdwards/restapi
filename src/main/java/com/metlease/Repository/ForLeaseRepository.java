package com.metlease.Repository;
import com.metlease.Entity.ForLease;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

public interface ForLeaseRepository extends JpaRepository<ForLease, Integer>, JpaSpecificationExecutor {
    @Query(value = "SELECT * FROM For_Lease INNER JOIN Apartment ON For_Lease.apartment_id=Apartment.id WHERE building_id = ?1", nativeQuery = true)
    List<ForLease> findByBuildingId(int id);
}