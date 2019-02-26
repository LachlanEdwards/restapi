package com.metlease.Repository;
import com.metlease.Entity.ForLease;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ForLeaseRepository extends JpaRepository<ForLease, Integer>, JpaSpecificationExecutor {
    @Query(value = "SELECT * FROM For_Lease INNER JOIN Apartment ON For_Lease.apartment_id=Apartment.id WHERE building_id = ?1", nativeQuery = true)
    List<ForLease> findByBuildingId(int id, Pageable pageable);

    @Override
    Page<ForLease> findAll(Pageable pageable);
}