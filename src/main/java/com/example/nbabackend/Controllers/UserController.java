package com.example.nbabackend.Controllers;

import com.example.nbabackend.Model.User;
import com.example.nbabackend.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService _userService;

    //GetById
    @GetMapping("/getUserId/{nickname}")
    public ResponseEntity<User> getUserById(@PathVariable String nickname){
        return _userService.getById(nickname);

    }


    //createUser
    @PostMapping("/createUser")
    public ResponseEntity createUser(@RequestBody User user){
        return _userService.createNewUser(user);
    }

}
