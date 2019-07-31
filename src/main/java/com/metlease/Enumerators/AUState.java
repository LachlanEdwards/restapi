package com.metlease.Enumerators;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AUState {
    QLD("QLD"),
    NSW("NSW"),
    VIC("VIC"),
    SA("SA"),
    WA("WA"),
    NT("NT"),
    ACT("ACT"),
    TAS("TAS");

    private String state;

    AUState(String state) {
        this.state = state.toUpperCase();
    }

    @JsonCreator
    public static AUState fromString(String suffix) {
        return AUState.valueOf(suffix.toUpperCase());
    }

    @JsonValue
    public String toString() {
        return this.state;
    }
}
