package com.kaagapov.checkToken.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String desc;
    private Date expire;

//    private Product() {};
//
//    public Product(String name, String desc, Date expire){
//        this.name = name;
//        this.desc = desc;
//        this.expire = expire;
//    }

    @Override
    public String toString() {
        return String.format("PRODUCT [id=%d, name=%s, desc=%s, expire=%s]", id, name, desc, expire);
    }

}
