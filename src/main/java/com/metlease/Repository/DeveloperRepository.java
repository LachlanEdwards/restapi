package com.metlease.Repository;
import com.metlease.Entity.Developer;
import com.metlease.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface DeveloperRepository extends CrudRepository<Developer, Integer> {

}
