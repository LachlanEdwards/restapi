package com.metlease.Enumerators;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StreetSuffix {
    @JsonProperty("Alley")
    ALLEY("Alley"),
    @JsonProperty("Arcade")
    ARCADE("Arcade"),
    @JsonProperty("Avenue")
    AVENUE("Avenue"),
    @JsonProperty("Boulevard")
    BOULEVARD("Boulevard"),
    @JsonProperty("Bypass")
    BYPASS("Bypass"),
    @JsonProperty("Circuit")
    CIRCUIT("Circuit"),
    @JsonProperty("Close")
    CLOSE("Close"),
    @JsonProperty("Corner")
    CORNER("Corner"),
    @JsonProperty("Court")
    COURT("Court"),
    @JsonProperty("Crescent")
    CRESCENT("Crescent"),
    @JsonProperty("Cul-de-sac")
    CULDESAC("Cul-de-sac"),
    @JsonProperty("Drive")
    DRIVE("Drive"),
    @JsonProperty("Esplanade")
    ESPLANADE("Esplanade"),
    @JsonProperty("Green")
    GREEN("Green"),
    @JsonProperty("Grove")
    GROVE("Grove"),
    @JsonProperty("Highway")
    HIGHWAY("Highway"),
    @JsonProperty("Junction")
    JUNCTION("Junction"),
    @JsonProperty("Lane")
    LANE("Lane"),
    @JsonProperty("Link")
    LINK("Link"),
    @JsonProperty("Mews")
    MEWS("Mews"),
    @JsonProperty("Parade")
    PARADE("Parade"),
    @JsonProperty("Place")
    PLACE("Place"),
    @JsonProperty("Ridge")
    RIDGE("Ridge"),
    @JsonProperty("Road")
    ROAD("Road"),
    @JsonProperty("Square")
    SQUARE("Square"),
    @JsonProperty("Street")
    STREET("Street"),
    @JsonProperty("Terrace")
    TERRACE("Terrace");

    private String suffix;

    StreetSuffix(String suffix) {
        this.suffix = suffix.toUpperCase();
    }

    @JsonCreator
    public static StreetSuffix fromString(String suffix) {
        return StreetSuffix.valueOf(suffix.toUpperCase());
    }

    @JsonValue
    public String toString() {
        return this.suffix;
    }
}

