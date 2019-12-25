package com.kaagapov.checkToken.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    private long productId;

    protected User(){};

    public User(String login, String password, long productId) {
        this.login = login;
        this.password = password;
        this.productId = productId;
    }

    @Override
    public String toString() {
        return String.format("USER [id=%d, login='%s', password='%s', product='%d']", id, login, password, productId);
    }
}
