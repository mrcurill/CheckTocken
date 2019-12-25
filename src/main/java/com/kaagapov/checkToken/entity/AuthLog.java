package com.kaagapov.checkToken.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class AuthLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private Date time;
    private Boolean resultAuth;

    protected AuthLog() {};

    public AuthLog(String login, Date time, Boolean resultAuth) {
        this.login = login;
        this.time = time;
        this.resultAuth = resultAuth;
    };
}
