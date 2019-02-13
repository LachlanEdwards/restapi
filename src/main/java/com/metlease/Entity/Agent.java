package com.metlease.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.metlease.Entity.Helpers.Parse;
import com.metlease.Exceptions.ParseException;
import com.metlease.Service.UserService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.metlease.Service.AgencyService;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Repository
@Scope("prototype")
@Entity
@Table(name = "Agents")
public class Agent extends StandardEntity {
    @Transient
    private AgencyService agencyService;
    @Transient
    private UserService userService;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String first;
    private String last;
    private int agency;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return first + " " + last;
    }

    @Override
    public void setName(String name) {
        try {
            String[] fl = Parse.parseName(name);
            this.first = fl[0];
            this.last = fl[1];
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Optional<Agency> getAgency() {
        return agencyService.getById(agency);
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
