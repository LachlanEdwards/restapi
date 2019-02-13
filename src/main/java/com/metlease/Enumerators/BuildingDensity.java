package com.metlease.Enumerators;

public enum BuildingDensity {
    HIGHDENSITY("High-density"),
    MIDDENSITY("Mid-density"),
    LOWDENSITY("Low-density");

    private String buildingDensity;

    BuildingDensity(String buildingClass) {
        this.buildingDensity = buildingClass;
    }

    public String toString() {
        return this.buildingDensity;
    }
}
