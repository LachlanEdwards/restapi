package com.metlease.Entity;

import com.metlease.Service.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.metlease.Enumerators.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Scope("prototype")
@Entity
@Table(name = "Buildings")
public class Building extends StandardEntity {
    @Transient
    ContractorService contractorService;
    @Transient
    DeveloperService developerService;
    @Transient
    ManagementService managementService;
    @Transient
    AgentService agentService;
    @Transient
    AgencyService agencyService;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer contractor;
    private Integer developer;
    private Integer agent;
    private Integer agency;
    private Integer management;
    private Date build;
    private String name;
    @Enumerated(EnumType.STRING)
    private BuildingClass buildingClass; //enum
    @Enumerated(EnumType.STRING)
    private BuildingCost buildingCost; //enum
    @Enumerated(EnumType.STRING)
    private BuildingDensity buildingDensity; //enum
    private String plan;
    private Integer features; //relationship
    private Float er;
    private String lon;
    private String lat;
    @ManyToOne
    private Scorecard scorecard;

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

    /*public Optional<Contractor> getContractor() {
        return contractorService.getById(contractor);
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor.getId();
    }

    public Optional<Developer> getDeveloper() {
        return developerService.getById(developer);
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer.getId();
    }

    public Optional<Management> getManagement() {
        return managementService.getById(management);
    }

    public void setManagement(Management management) {
        this.management = management.getId();
    }

    public Optional<Agent> getAgent() {
        return agentService.getById(agent);
    }

    public void setAgent(Agent agent) {
        this.agent = agent.getId();
    }

    public Optional<Agency> getAgency() {
        return agencyService.getById(agency);
    }

    public void setAgency(Agency agency) {
        this.agency = agency.getId();
    }*/

    public Date getBuild() {
        return build;
    }

    public void setBuild(Date build) {
        this.build = build;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
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

    public int getFeatures() {
        System.out.println(features);
        return features;
    }

    public void setFeatures(int features) {
        this.features = features;
    }

    public float getEr() {
        return er;
    }

    public void setEr(float er) {
        this.er = er;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Scorecard getScorecard() {
        return scorecard;
    }

    public void setScorecard(Scorecard scorecard) {
        this.scorecard = scorecard;
    }
}
