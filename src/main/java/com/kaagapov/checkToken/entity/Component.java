package com.kaagapov.checkToken.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
//TODO SpringDataRest
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ElementCollection(targetClass = String.class)
    private List<String> users;
    @ElementCollection(targetClass = String.class)
    private  List<String> roles;
    @ElementCollection(targetClass = String.class)
    private List<String> buttons;
    @ElementCollection(targetClass = String.class)
    private List<String> inputs;
}
