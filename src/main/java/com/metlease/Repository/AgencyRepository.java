package com.metlease.Repository;
import com.metlease.Entity.Agency;
import com.metlease.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface AgencyRepository extends CrudRepository<Agency, Integer> {

}