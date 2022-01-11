package com.example.nbabackend.Controllers;

import com.example.nbabackend.Model.User;
import com.example.nbabackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    @Autowired
    UserService _userService;

    //GetById
    @GetMapping("/getUserId/{nickname}")
    public ResponseEntity<User> getUserById(@PathVariable String nickname){
        return _userService.getById(nickname);

    }


    //createUser
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){
        return _userService.createNewUser(user);
    }

}
