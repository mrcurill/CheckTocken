package com.kaagapov.checkToken.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Login {
    private String login;
    private String password;
}
