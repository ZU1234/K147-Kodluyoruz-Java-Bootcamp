package com.medium.controller;


import com.medium.model.Follow;
import com.medium.model.User;
import com.medium.model.UserTag;
import com.medium.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
//Bu sınıf dışarı ile olan bağlantıyı sağlayacak.
public class UserController {
    @Autowired //injection işlemi gerçekleşir. spring tarafından oluşturulan objenin bağlanmasını sağlar.
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
    @GetMapping(value ="/{email}")  //GET /users/{email} şeklinde methodu kullanmamızı sağlar.
    public User getByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    @PostMapping(value = "/follow")     //GET /{follow} şeklinde methodu kullanmamızı sağlar.
    //Kullanıcın kullanıcıları takip etmesini sağlar.
    public ResponseEntity<Follow>userFollow(@RequestBody Follow follow) {
        userService.createFollow(follow);
        return new ResponseEntity<>(follow, HttpStatus.OK);

    }
    @GetMapping(value ="/follow")  //GET /{follow} şeklinde methodu kullanmamızı sağlar.
    // Kullanıcının takip ettikleri listelenir.
    public ResponseEntity<List<String>> getByUserFollow(@RequestBody User user) {
       List<String> myList= userService.printAllFollowByUser(user);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    @PostMapping(value = "/tag")     //GET /{tag} şeklinde methodu kullanmamızı sağlar.
    //Kullanıcın tagleri takip etmesini sağlar.
    public ResponseEntity<UserTag>createTag(@RequestBody UserTag userTag) {
        userService.createTagType(userTag);
        return new ResponseEntity<>(userTag, HttpStatus.OK);

    }
    @GetMapping(value ="/tag")  //GET /{tag} şeklinde methodu kullanmamızı sağlar.
    // Kullanıcının takip ettikleği tagler listelenir.
    public ResponseEntity<List<String>> getByUserTag(@RequestBody User user) {
        List<String> myList= userService.printAllUserTagList(user).stream().map(s->s.name()).toList();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }


}
