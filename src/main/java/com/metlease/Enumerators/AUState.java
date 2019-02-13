package com.metlease.Enumerators;

public enum AUState {
    QLD("Queensland"),
    NSW("New South Wales"),
    VIC("Victoria"),
    SA("South Australia"),
    WA("Western Australia"),
    NT("Northen Territory"),
    ACT("Australian Capitol Territory"),
    TAS("Tasmania");

    private String state;

    AUState(String state) {
        this.state = state;
    }

    public String toString() {
        return this.state;
    }
}
