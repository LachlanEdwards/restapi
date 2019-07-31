package com.metlease.Entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.metlease.Entity.Helpers.StreetAddress;
import com.metlease.Enumerators.AUState;
import com.metlease.Enumerators.StreetSuffix;
import com.metlease.Service.UserService;
import org.hibernate.validator.constraints.URL;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class StandardEntity {
    @Transient
    UserService userService;

    @NotNull
    @Size(min=2, max=255)
    @Email
    private String mail;

    @NotNull
    @Size(min=2, max=255)
    private String phone;

    private String image;

    @NotNull
    @Size(min=2, max=255)
    @URL
    private String website;

    @NotNull
    @Size(min=2, max=999)
    private String description;

    private Integer admin_id;

    @NotNull
    @Size(min=2, max=255)
    private String name;

    @Size(min=2, max=255)
    private String unit;

    @NotNull
    private Integer number;

    @NotNull
    @Size(min=2, max=255)
    private String street_name;

    @NotNull
    private StreetSuffix suffix;

    @NotNull
    @Size(min=2, max=255)
    private String suburb;

    @NotNull
    private AUState state;

    @NotNull
    private Integer post_code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getAdmin() {
        return admin_id;
    }

    public void setAdmin(Integer adminId) {
        this.admin_id = adminId;
    }

    public StreetAddress getAddress() {
        //StreetSuffix eSuffix = StreetSuffix.valueOf(suffix);
        //AUState eState = AUState.valueOf(state);
        return new StreetAddress(unit, number, street_name, suffix, suburb, state, post_code);
    }

    @JsonDeserialize(builder = StreetAddress.class)
    public void setAddress(StreetAddress address) {
        this.unit = address.getUnit();
        this.number = address.getNumber();
        this.street_name = address.getStreetName();
        this.suffix = address.getSuffix();
        this.suburb = address.getSuburb();
        this.state = address.getState();
        this.post_code = address.getPostCode();
    }
}
