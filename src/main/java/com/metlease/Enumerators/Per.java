package com.metlease.Enumerators;

public enum Per {
    DAY("Day"),
    WEEK("Week"),
    MONTH("Month"),
    QUATER("Quater"),
    YEAR("Year");

    private String per;

    Per(String state) {
        this.per = per;
    }

    public String toString() {
        return this.per;
    }
}
