package com.metlease.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.metlease.Entity.Helpers.Mean;
import com.metlease.Service.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.metlease.Enumerators.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Optional;

@Scope("prototype")
@Entity
@Table(name = "Buildings")
public class Building extends StandardEntity {
    @Transient
    @Autowired
    BuildingService buildingService;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min=2, max=255)
    private String contractor;

    @NotNull
    @Size(min=2, max=255)
    private String developer;

    @NotNull
    @Size(min=2, max=255)
    private String management;

    @NotNull
    @Past
    private Date buildDate;

    @Transient
    private Double mean;

    @Enumerated(EnumType.STRING)
    @NotNull
    private BuildingClass buildingClass;

    @Enumerated(EnumType.STRING)
    @NotNull
    private BuildingCost buildingCost;

    @Enumerated(EnumType.STRING)
    @NotNull
    private BuildingDensity buildingDensity;

    @Size(min=2, max=255)
    @URL
    private String pda;

    @NotNull
    @Size(min=2, max=999)
    private String features;

    @Size(min=2, max=255)
    private String masterPlan;

    @NotNull
    @NumberFormat(style= NumberFormat.Style.DEFAULT)
    private Float environmentRating;

    @NotNull
    @NumberFormat(style= NumberFormat.Style.DEFAULT)
    private Integer towers;

    @NotNull
    @NumberFormat(style= NumberFormat.Style.DEFAULT)
    private Integer floors;

    private String longitude;
    private String latitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getManagement() {
        return management;
    }

    public void setManagement(String management) {
        this.management = management;
    }

    public Date getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(Date buildDate) {
        this.buildDate = buildDate;
    }

    public String getPda() {
        return pda;
    }

    public void setPda(String pda) {
        this.pda = pda;
    }

    public String getBuildingClass() {
        return buildingClass.toString();
    }

    public void setBuildingClass(BuildingClass buildingClass) {
        this.buildingClass = buildingClass;
    }

    public String getBuildingDensity() {
        return buildingDensity.toString();
    }

    public void setBuildingDensity(BuildingDensity buildingDensity) {
        this.buildingDensity = buildingDensity;
    }

    public String getBuildingCost() {
        return buildingCost.toString();
    }

    public void setBuildingCost(BuildingCost buildingCost) {
        this.buildingCost = buildingCost;
    }

    public String getFeatures() {
        System.out.println(features);
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public float getEnvironmentRating() {
        return environmentRating;
    }

    public void setEnvironmentRating(float environmentRating) {
        this.environmentRating = environmentRating;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getMasterPlan() {
        return masterPlan;
    }

    public void setMasterPlan(String masterPlan) {
        this.masterPlan = masterPlan;
    }

    public void setEnvironmentRating(Float environmentRating) {
        this.environmentRating = environmentRating;
    }

    public Integer getTowers() {
        return towers;
    }

    public void setTowers(Integer towers) {
        this.towers = towers;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }
}
