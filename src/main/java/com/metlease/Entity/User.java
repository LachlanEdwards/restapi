package com.metlease.Entity;

import com.metlease.Enumerators.UserRole;
import com.metlease.Enumerators.UserGender;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

import java.util.Date;
import java.sql.*;

@Repository
@Scope("prototype")
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String first;
    private String last;
    private String mail;
    private String phone;
    private String image;
    private int gender;
    private int role;
    private Date birthday;
    private String username;
    @ManyToOne
    private Building building;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getFirst() {
        return first;
    }
    public void setFirst(String first) {
        this.first = first;
    }
    public String getLast() {
        return last;
    }
    public void setLast(String last) {
        this.last = last;
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
    public void setImage(String url) {
        this.image = url;
    }
    public UserGender getGender() {
        UserGender eUserGender = UserGender.valueOf(gender);
        return eUserGender;
    }
    public void setGender(UserGender gender) {
        this.gender = gender.toInt();
    }
    public UserRole getRole() {
        UserRole eUserRole = UserRole.valueOf(role);
        return eUserRole;
    }
    public void setRole(UserRole role) {
        this.role = role.toInt();
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
