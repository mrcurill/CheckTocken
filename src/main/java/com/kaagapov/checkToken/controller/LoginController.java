package com.kaagapov.checkToken.controller;

import com.kaagapov.checkToken.Authentication;
import com.kaagapov.checkToken.entity.User;
import com.kaagapov.checkToken.pojo.Login;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//TODO время сесси
//TODO новая таблица справочник liquibase insert перед запуском
//TODO ответ в json одни объекты одному пользователю, другие другому

//TODO добавить кнопку на форму и новый api для создания нового пользователя
//TODO после создания сразу зайти под ним
@RestController
@Log
public class LoginController {

    @Autowired
    Authentication authentication;

    String loginFormPath = "./src/main/resources/templates/login.html";
    String loginFormHtml = new String(Files.readAllBytes(Paths.get(loginFormPath)));

    public LoginController() throws IOException {
    }

    @RequestMapping(value = "/login", method = RequestMethod.OPTIONS)
    public ResponseEntity options() {
        log.info("OPTIONS /login called");
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .build();
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity getLoginFormController(){
        log.info("LOG LOGIN_FORM: Invocked");
        return new ResponseEntity(loginFormHtml, HttpStatus.OK);
    }

    @GetMapping("/login")
    @ResponseBody
    public ResponseEntity getLoginController(String username, String password){
        ResponseEntity<String> responseEntity;

        log.info("LOG GET LOGIN : Invoked");
        log.info("LOG GET LOGIN : username: ".concat(username));
        log.info("LOG GET LOGIN : password: ".concat(password));

        if( authentication.checkAuth(username) ) {
            responseEntity = new ResponseEntity("Success login", HttpStatus.OK);
            log.info("LOG LOGIN : success login"); }
        else {
            responseEntity = new ResponseEntity("Access denied", HttpStatus.UNAUTHORIZED);
            log.info("LOG LOGIN : failed login");
        }
        return responseEntity;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity postLoginController(@RequestBody Login login){
        ResponseEntity<String> responseEntity;

        log.info("LOG POST LOGIN : Invoked");
        log.info("LOG POST LOGIN : username: ".concat(login.getLogin()));
        log.info("LOG POST LOGIN : password: ".concat(login.getPassword()));

        if( authentication.checkAuth(login.getLogin()) ) {
            responseEntity = new ResponseEntity("Success login", HttpStatus.OK);
            log.info("LOG LOGIN : success login"); }
        else {
            responseEntity = new ResponseEntity("Access denied", HttpStatus.UNAUTHORIZED);
            log.info("LOG LOGIN : failed login");
        }

        return responseEntity;
    }

//    @PostMapping
//    @ResponseBody
//    public ResponseEntity postCreateLoginController(@RequestBody Login login) {
//        ResponseEntity<String> responseEntity;
//
//        log.info("LOG CREATE LOGIN : Invoked");
//        log.info("LOG CREATE LOGIN : username: ".concat(login.getLogin()));
//        log.info("LOG CREATE LOGIN : Invoked".concat(login.getPassword()));
//
//        responseEntity = new ResponseEntity("Success Create User", HttpStatus.OK);
//
//        //return responseEntity;
//        return ResponseEntity.ok().
//                header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").build();
//    }

    @PostMapping("/login2")
    @ResponseBody
    public ResponseEntity postLoginController2(){

        log.info("LOG POST LOGIN 2 : Invoked");

        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .build();
    }
}
