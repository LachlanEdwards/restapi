package com.metlease.Entity;

import com.metlease.Enumerators.Per;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;

@Repository
@Scope("prototype")
@Entity
@Table(name = "For_Lease")
public class ForLease extends ForType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer cost;
    private Date available;
    private Integer bond;
    @ManyToOne
    private Apartment apartment;
    @Enumerated(EnumType.STRING)
    private Per per;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Per getPer() {
        return per;
    }

    public void setPer(Per per) {
        this.per = per;
    }

    public Date getAvailable() {
        return available;
    }

    public void setAvailable(Date available) {
        this.available = available;
    }

    public Integer getBond() {
        return bond;
    }

    public void setBond(Integer bond) {
        this.bond = bond;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
}
