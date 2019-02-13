package com.metlease.Enumerators;

public enum ApartmentFeature {
    WARDROBE("Built-in Wardrobe"),
    BALCONY("Balcony"),
    DISHWASHER("Built-in Dishwasher"),
    STORAGE("Storage"),
    MICROWAVE("Built-in Microwave"),
    HVAC("Air Conditioning"),
    CARPET("Carpet"),
    FURNISHED("Furnished"),
    DRYER("Dryer"),
    DUALSINK("Dual Sink"),
    BATH("Bath");

    private String feature;

    ApartmentFeature(String feature) {
        this.feature = feature;
    }

    public String toString() {
        return this.feature;
    }
}
