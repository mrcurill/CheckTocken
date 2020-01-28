package com.kaagapov.checkToken.entity;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    @ElementCollection
    private List<String> roles;
    @ElementCollection
    private List<String> components;
}
