package com.metlease.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
@Scope("prototype")
@Entity
@Table(name = "Rating_Card")
public class RatingCard {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Transient
    private int aggregate;
    private int management;
    private int functionality;
    private int facilities;
    private int neighbourhood;
    private int culture;
    private int fittings;
    private int noise;
    private int crime;
    private int lifestyle;
    private int commute;
    private int schools;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAggregate() {
        int[] scores = { management, functionality, facilities, neighbourhood, culture, fittings, noise, crime, lifestyle, commute, schools};
        int sum = 0;

        for (int i = 0; i < scores.length; i++) {
            sum = sum + scores[i];
        }
        aggregate = sum / scores.length;
        return aggregate;
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

    public int getCrime() {
        return crime;
    }

    public void setCrime(int crime) {
        this.crime = crime;
    }

    public int getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(int lifestyle) {
        this.lifestyle = lifestyle;
    }

    public int getCommute() {
        return commute;
    }

    public void setCommute(int commute) {
        this.commute = commute;
    }

    public int getSchools() {
        return schools;
    }

    public void setSchools(int schools) {
        this.schools = schools;
    }
}
