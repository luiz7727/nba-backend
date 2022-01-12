package com.example.nbabackend.Controllers;

import com.example.nbabackend.Model.User;
import com.example.nbabackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    UserService _userService;


    //Get All Users
    @GetMapping("/getAll")
    public List<User> getAllUsers (){

        return _userService.getAllUsers();
    }

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

    //User Registreded
    @PostMapping("/userRegistred")
    public HttpStatus userCreated(@RequestBody User user){
        return _userService.userAlreadyCreated(user);
    }

}
