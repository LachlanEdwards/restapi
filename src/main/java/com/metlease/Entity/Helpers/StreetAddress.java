package com.metlease.Entity.Helpers;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.metlease.Enumerators.AUState;
import com.metlease.Enumerators.StreetSuffix;

@JsonPOJOBuilder(buildMethodName = "create", withPrefix = "set")
public class StreetAddress {
    private String unit;
    private Integer number;
    private String street_name;
    private StreetSuffix suffix;
    private String suburb;
    private AUState state;
    private Integer post_code;

    public StreetAddress(String unit, int number, String street, StreetSuffix suffix, String suburb, AUState state, int postcode) {
        this.unit = unit;
        this.number = number;
        this.street_name = street;
        this.suffix = suffix;
        this.suburb = suburb;
        this.state = state;
        this.post_code = postcode;
    }

    public StreetAddress() {}

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStreetName() {
        return street_name;
    }

    public void setStreetName(String street_name) {
        this.street_name = street_name;
    }

    public StreetSuffix getSuffix() {
        return suffix;
    }

    public void setSuffix(StreetSuffix suffix) {
        this.suffix = suffix;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public AUState getState() {
        return state;
    }

    public void setState(AUState state) {
        this.state = state;
    }

    public Integer getPostCode() {
        return post_code;
    }

    public void setPostCode(Integer post_code) {
        this.post_code = post_code;
    }
}
