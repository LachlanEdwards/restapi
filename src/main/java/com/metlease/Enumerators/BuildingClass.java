package com.metlease.Enumerators;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BuildingClass {
    HIGHRISE("High-rise"),
    MIDRISE("Mid-rise"),
    LOWRISE("Low-rise"),
    DUPLEX("Duplex"),
    CONDOMINIUM("Condominium"),
    TOWN("Townhouse"),
    SHAREHOUSE("Share house"),
    ROOMSHARE("Room share"),
    HOUSE("House");

    private String buildingClass;

    BuildingClass(String buildingClass) {
        this.buildingClass = buildingClass.valueOf(buildingClass.toUpperCase());
    }

    @JsonCreator
    public static BuildingClass fromString(String buildingClass) {
        return BuildingClass.valueOf(buildingClass.toUpperCase().replace("-",""));
    }

    @JsonValue
    public String toString() {
        return this.buildingClass;
    }
}
