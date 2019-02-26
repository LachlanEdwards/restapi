package com.metlease.Entity;

import com.metlease.Entity.Helpers.StreetAddress;
import com.metlease.Enumerators.AUState;
import com.metlease.Enumerators.StreetSuffix;
import com.metlease.Service.UserService;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.Optional;

@MappedSuperclass
public class StandardEntity {
    @Transient
    UserService userService;

    private String mail;
    private String phone;
    private String image;
    private String website;
    private Integer rating;
    private String description;
    @ManyToOne
    private User admin;
    private Integer subunit;
    private Integer number;
    private String streetname;
    private String suffix;
    private String suburb;
    private String state;
    private Integer postcode;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User id) {
        this.admin = id;
    }

    public StreetAddress getAddress() {
        StreetSuffix eSuffix = StreetSuffix.valueOf(suffix);
        AUState eState = AUState.valueOf(state);
        return new StreetAddress(subunit, number, streetname, eSuffix, suburb, eState, postcode);
    }

    public void setAddress(StreetAddress address) {
        this.subunit = address.getUnit();
        this.number = address.getNumber();
        this.streetname = address.getStreetName();
        this.suffix = address.getSuffix().toString();
        this.suburb = address.getSuburb();
        this.state = address.getState().toString();
        this.postcode = address.getPostCode();
    }
}
