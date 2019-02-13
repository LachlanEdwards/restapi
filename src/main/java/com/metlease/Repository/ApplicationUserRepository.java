package com.metlease.Repository;
import com.metlease.Entity.ApplicationUser;
import com.metlease.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {
    ApplicationUser findByUsername(String username);
}