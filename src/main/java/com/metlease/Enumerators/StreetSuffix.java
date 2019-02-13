package com.metlease.Enumerators;

import java.security.MessageDigest;

public enum StreetSuffix {
    ALLEY("Alley"),
    ARCADE("Archade"),
    AVENUE("Avenue"),
    BOULEVARD("Boulevard"),
    BYPASS("Bypass"),
    CIRCUIT("Circuit"),
    CLOSE("Close"),
    CORNER("Corner"),
    COURT("Court"),
    CRESCENT("Crescent"),
    CULDESAC("Cul-de-sac"),
    DRIVE("Drive"),
    ESPLANADE("Esplanade"),
    GREEN("Green"),
    GROVE("Grove"),
    HIGHWAY("Highway"),
    JUNCTION("Junction"),
    LANE("Lane"),
    LINK("Link"),
    MEWS("Mews"),
    PARADE("Parade"),
    PLACE("Place"),
    RIDGE("Ridge"),
    ROAD("Road"),
    SQUARE("Square"),
    STREET("Street"),
    TERRACE("Terrace");

    private String suffix;

    StreetSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String toString() {
        return this.suffix;
    }
}

