package com.metlease.Entity;

import com.metlease.Entity.Helpers.StreetAddress;
import com.metlease.Service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Optional;

@Repository
@Scope("prototype")
@Entity
@Table(name = "Managements")
public class Management extends StandardEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
