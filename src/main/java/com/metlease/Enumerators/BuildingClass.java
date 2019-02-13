package com.metlease.Enumerators;

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
        this.buildingClass = buildingClass;
    }

    public String toString() {
        return this.buildingClass;
    }
}
