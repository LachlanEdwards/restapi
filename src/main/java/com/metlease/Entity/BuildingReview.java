package com.metlease.Entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;

@Repository
@Scope("prototype")
@Entity
@Table(name = "Building_Reviews")
public class BuildingReview {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Building building;
    @ManyToOne
    private User user;
    private Date date;
    private String comment;
    private int aggregate;
    private int management;
    private int functionality;
    private int facilities;
    private int neighbourhood;
    private int culture;
    private int fittings;
    private int noise;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAggregate() {
        return aggregate;
    }

    public void setAggregate(int aggregate) {
        this.aggregate = aggregate;
    }

    public int getManagement() {
        return management;
    }

    public void setManagement(int management) {
        this.management = management;
    }

    public int getFunctionality() {
        return functionality;
    }

    public void setFunctionality(int functionality) {
        this.functionality = functionality;
    }

    public int getFacilities() {
        return facilities;
    }

    public void setFacilities(int facilities) {
        this.facilities = facilities;
    }

    public int getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(int neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public int getCulture() {
        return culture;
    }

    public void setCulture(int culture) {
        this.culture = culture;
    }

    public int getFittings() {
        return fittings;
    }

    public void setFittings(int fittings) {
        this.fittings = fittings;
    }

    public int getNoise() {
        return noise;
    }

    public void setNoise(int noise) {
        this.noise = noise;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
