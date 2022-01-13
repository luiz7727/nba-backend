package com.example.nbabackend.Controllers;

import com.example.nbabackend.Model.User;
import com.example.nbabackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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
    @PostMapping("/userRegistred/{nickname}")
    public HttpStatus userCreated(@PathVariable String nickname){
        return _userService.userAlreadyCreated(nickname);
    }

    //Updating infos user
    @PutMapping("/updateInfoUsers/{nickname}")
    public ResponseEntity<User> updateInfosCardUser(@PathVariable String nickname,@RequestBody User newInfoCardUser){

        return _userService.putUserCardInfo(nickname,newInfoCardUser);
    }

}
