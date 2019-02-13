package com.metlease.Repository;
import com.metlease.Entity.Contractor;
import com.metlease.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface ContractorRepository extends CrudRepository<Contractor, Integer> {

}
