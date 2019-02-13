package com.metlease.Enumerators;

public enum BuildingFeature {
    POOL("Pool"),
    ROOFTOP("Rooftop"),
    GYM("Gym"),
    RECROOM("Recreation Room"),
    RECDECK("Recreation Deck"),
    BBQ("BBQ"),
    INTERCOM("Intercom"),
    SECUREPARKING("Secure Parking"),
    DUCTEDAC("Ducted Air Conditioning"),
    ALARMSYS("Alarm System"),
    THEATRE("Theatre"),
    PETS("Pet Friendly"),
    HIGHSPEED("High-Speed Broadband Connection"),
    PAYTV("Pay TV Access"),
    VISITORPARKING("Visitor Parking"),
    SMOKING("Smoking Permitted");



    private String feature;

    BuildingFeature(String feature) {
        this.feature = feature;
    }

    public String toString() {
        return this.feature;
    }
}
