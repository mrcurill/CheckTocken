package com.kaagapov.checkToken.controller;

import com.kaagapov.checkToken.Authentication;
import com.kaagapov.checkToken.entity.Component;
import com.kaagapov.checkToken.entity.User;
import com.kaagapov.checkToken.repo.UserRepository;
import com.kaagapov.checkToken.repo.ComponentRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO spring session/spring security
//TODO напихать в базу говнеца
//TODO поверх него CRUD
//TODO модель DAO на request/response GET attribute request (вход: login),
//TODO mapstruct маппинг объектов
//TODO транзакционность



@RestController
@Log
public class LoginController {

    @Autowired
    Authentication authentication;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ComponentRepository componentRepository;

    public LoginController() {
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity postLoginController(@RequestBody User rqUser) {
        ResponseEntity responseEntity;

        log.info("LOG POST LOGIN : ---------------------------------------------------------------");
        log.info("LOG POST LOGIN : username: ".concat(rqUser.getLogin()));
        log.info("LOG POST LOGIN : password: ".concat(rqUser.getPassword()));

        if( authentication.checkAuth(rqUser) ) {
            responseEntity = new ResponseEntity("Success login", HttpStatus.OK);
            log.info("LOG LOGIN : success login"); }
        else {
            responseEntity = new ResponseEntity("Access denied", HttpStatus.UNAUTHORIZED);
            log.info("LOG LOGIN : failed login"); }

        return responseEntity;
    }

    @PostMapping("/users")
    @ResponseBody
    public ResponseEntity postGetUsersController() {
        ResponseEntity<Iterable<User>> responseEntity;

        log.info("LOG USERS : --------------------------------------------------------------------");

        Iterable<User> users = userRepository.findAll();

        log.info("LOG USERS : Returned Users:");
        for(User user : users){
            log.info("LOG USERS : ".concat(user.toString())); }

        responseEntity = new ResponseEntity(users, HttpStatus.OK);

        return responseEntity;
    }

    @PostMapping("/users/create")
    @ResponseBody
    public ResponseEntity postCreateUserController(@RequestBody User rqUser) {
        ResponseEntity<String> responseEntity = new ResponseEntity("Success Create User", HttpStatus.OK);

        log.info("LOG CREATE LOGIN : -------------------------------------------------------------");
        log.info("LOG CREATE LOGIN : create user : ".concat(rqUser.getLogin()));

        userRepository.save(rqUser);

        for( String componentName : rqUser.getComponents() ) {
            List<Component> components = componentRepository.findByName(componentName);

            if(!components.isEmpty()) {
                Component component = components.get(0);
                List<String> users = component.getUsers();
                users.add(rqUser.getLogin());
                component.setUsers(users);
                componentRepository.save(component);
            }
        }

        return responseEntity;
    }

    @PostMapping("/users/components")
    @ResponseBody
    public ResponseEntity postGetUserComponentsController(@RequestBody User rqUser) {
        ResponseEntity<Iterable<Component>> responseEntity;

        log.info("LOG USER COMPONENTS : ----------------------------------------------------------");

        List<User> users = userRepository.findByLogin(rqUser.getLogin());

        if(!users.isEmpty()) {
            User user = users.get(0);
            List<Component> components = new ArrayList<>();

            for( String componentName : user.getComponents()) {
                components.add(componentRepository.findByName(componentName).get(0));
            }

            responseEntity = new ResponseEntity<>(components, HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<>(HttpStatus.OK); }

        return responseEntity;
    }

    @PostMapping("/components")
    @ResponseBody
    public ResponseEntity postGetComponents() {

        log.info("LOG COMPONENTS : ----------------------------------------------------------------");
        Iterable<Component> components = componentRepository.findAll();

        log.info("LOG COMPONENTS : returned components: ");
        for(Component component : components) {
            log.info("LOG COMPONENTS : ".concat(component.toString()));
        }

        ResponseEntity<Iterable<Component>> responseEntity = new ResponseEntity<>(components, HttpStatus.OK);

        return responseEntity;
    }

    @PostMapping("/components/create")
    @ResponseBody
    public ResponseEntity postCreateComponent(@RequestBody Component rqComponent) {
        ResponseEntity responseEntity = new ResponseEntity("Component ".concat(rqComponent.getName().concat(" created")), HttpStatus.OK);

        log.info("LOG COMPONENTS CREATE: ----------------------------------------------------------");
        log.info("LOG COMPONENTS CREATE: ".concat(rqComponent.getName()));

        componentRepository.save(rqComponent);

        for( String userLogin : rqComponent.getUsers()) {
            List<User> users = userRepository.findByLogin(userLogin);

            if( !users.isEmpty() ) {
                User user = users.get(0);
                List<String> userComponents = user.getComponents();
                userComponents.add(rqComponent.getName());
                user.setComponents(userComponents);
                userRepository.save(user);
            }
        }

        return responseEntity;
    }

    @PostMapping("/components/users")
    @ResponseBody
    public ResponseEntity postGetComponentUsersController(@RequestBody Component rqComponent) {
        ResponseEntity<Iterable<User>> responseEntity;

        log.info("LOG COMPONENT USERS : ----------------------------------------------------------");

        List<Component> components = componentRepository.findByName(rqComponent.getName());
        List<User> users = new ArrayList<>();

        if(!components.isEmpty()) {
            Component component = components.get(0);
            for(String userLogin : component.getUsers()) {
                users.add(userRepository.findByLogin(userLogin).get(0)); }

            responseEntity = new ResponseEntity<>(users, HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<>(HttpStatus.OK); }

        return responseEntity;
    }
}
