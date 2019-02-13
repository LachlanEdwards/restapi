package com.metlease.Enumerators;

public enum BuildingCost {
    SERVICED("Serviced"),
    HIGHCOST("High-cost"),
    AVERAGECOST("Average-cost"),
    LOWCOST("Low-cost");

    private String buildingCost;

    BuildingCost(String buildingClass) {
        this.buildingCost = buildingClass;
    }

    public String toString() {
        return this.buildingCost;
    }
}
