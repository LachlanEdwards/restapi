package com.metlease.Enumerators;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BuildingCost {
    SERVICED("Serviced"),
    HIGHCOST("High-cost"),
    AVERAGECOST("Average-cost"),
    LOWCOST("Low-cost");

    private String buildingCost;

    BuildingCost(String buildingClass) {
        this.buildingCost = buildingClass.toUpperCase();
    }

    @JsonCreator
    public static BuildingCost fromString(String buildingCost) {
        return BuildingCost.valueOf(buildingCost.toUpperCase().replace("-",""));
    }

    @JsonValue
    public String toString() {
        return this.buildingCost;
    }
}
