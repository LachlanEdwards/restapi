package com.metlease.Entity;

import com.metlease.Enumerators.Per;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;

@Repository
@Scope("prototype")
@Entity
@Table(name = "For_Sale")
public class ForSale extends ForType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
