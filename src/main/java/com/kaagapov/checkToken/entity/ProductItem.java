package com.kaagapov.checkToken.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String desc;
    private Integer cost;
    private long productId;

//    private ProductItem() {};
//
//    public ProductItem(String name, String desc, Number cost, Long productId) {
//        this.name = name;
//        this.desc = desc;
//        this.cost = cost;
//        this.productId = productId;
//    }

    @Override
    public String toString() {
        return String.format("       PRODUCT ITEM [id=%d, name=%s, desc=%s, cost=%d]", id, name, desc, cost);
    }
}
