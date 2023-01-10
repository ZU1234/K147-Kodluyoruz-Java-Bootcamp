package com.emlakcepte.question1A.controller;

import com.emlakcepte.question1A.model.User;
import com.emlakcepte.question1A.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping //GET  /users  şeklinde methodu kullanmamızı sağlar.Tüm userları getirir.
    public List<User> getAll() {
        return userService.getAllUser();
    }
    @PostMapping    //POST /users şeklinde methodu kullanmamızı sağlar. Yeni user oluşturur.
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
