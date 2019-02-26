package com.metlease.Entity;

import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;

public class BuildingReviewPayload {
    private int user;
    private String comment;
    private int management;
    private int functionality;
    private int facilities;
    private int neighbourhood;
    private int culture;
    private int fittings;
    private int noise;
    private int aggregate;

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getAggregate() {
        return aggregate;
    }

    public void setAggregate() {
        this.aggregate = aggregate;
    }
}
