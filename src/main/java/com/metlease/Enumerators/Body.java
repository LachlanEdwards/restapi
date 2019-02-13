package com.metlease.Enumerators;

public enum Body {
    AGENCY("Agency"),
    BUILDING("Building"),
    MANAGEMENT("Management"),
    CONTRACTOR("Contractor"),
    DEVELOPER("Developer"),
    AGENT("Agent"),
    APARTMENT("Apartment");

    private String body;

    Body(String state) {
        this.body = body;
    }

    public String toString() {
        return this.body;
    }
}
