package com.metlease.Enumerators;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BuildingDensity {
    HIGHDENSITY("High-density"),
    MIDDENSITY("Mid-density"),
    LOWDENSITY("Low-density");

    private String buildingDensity;

    BuildingDensity(String buildingClass) {
        this.buildingDensity = buildingClass.toUpperCase();
    }

    @JsonCreator
    public static BuildingDensity fromString(String buildingDensity) {
        return BuildingDensity.valueOf(buildingDensity.toUpperCase().replace("-",""));
    }

    @JsonValue
    public String toString() {
        return this.buildingDensity;
    }
}
