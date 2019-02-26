package com.metlease.Repository;
import com.metlease.Entity.ForLease;
import com.metlease.Entity.ForSale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Table;
import java.util.List;

public interface ForSaleRepository extends JpaRepository<ForSale, Integer>, JpaSpecificationExecutor {
    @Query(value = "SELECT * FROM For_Sale INNER JOIN Apartment ON For_Sale.apartment_id=Apartment.id WHERE building_id = ?1", nativeQuery = true)
    List<ForSale> findByBuildingId(int id);
    @Override
    Page<ForSale> findAll(Pageable pageable);
}