package com.metlease.Entity.Helpers;

import com.metlease.Enumerators.AUState;
import com.metlease.Enumerators.StreetSuffix;

public class StreetAddress {
    private Integer unit;
    private Integer number;
    private String streetname;
    private StreetSuffix suffix;
    private String suburb;
    private AUState state;
    private Integer postcode;

    public StreetAddress(int unit, int number, String street, StreetSuffix suffix, String locality, AUState state, int postcode) {
        this.unit = unit;
        this.number = number;
        this.streetname = street;
        this.suffix = suffix;
        this.suburb = locality;
        this.state = state;
        this.postcode = postcode;
    }

    public Integer getUnit() {
        return unit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getStreetName() {
        return streetname;
    }

    public String getSuffix() {
        return suffix.toString();
    }

    public String getSuburb() {
        return suburb;
    }

    public AUState getState() {
        return state;
    }

    public Integer getPostCode() {
        return postcode;
    }
}
