package com.metlease.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.metlease.Enumerators.UserGender;
import com.metlease.Enumerators.UserRole;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;

@Repository
@Scope("prototype")
@Entity
@Table(name = "Users")
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String first;
    private String last;
    private String username;
    private String mail;
    private String phone;
    private String image;
    private int gender;
    private int role;
    private Date birthday;
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isAccountEnabled() {
        return true;
    }
}
