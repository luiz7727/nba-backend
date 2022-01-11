package com.example.nbabackend.Service;

import com.example.nbabackend.Model.User;
import com.example.nbabackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class UserService {

    @Autowired
    private UserRepository _userRepository;

    //getting all users
    public List<User> getAllUsers(){
        return _userRepository.findAll();
    }

    //create a new user
    public ResponseEntity createNewUser(@RequestBody User user){

        _userRepository.save(user);

        return new ResponseEntity(HttpStatus.OK);
    }

    //Get User By id
    public ResponseEntity<User> getById(@PathVariable String nickname){

        Optional<User> user = _userRepository.findByName(nickname);

        if(user.isPresent()){
            return new ResponseEntity<User>(user.get(),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Put User just By IdName
    public ResponseEntity<User> putUser(@PathVariable String nicknamePath, @RequestBody User nickname){
        Optional<User> olduser = _userRepository.findByName(nicknamePath);

        if(olduser.isPresent()){
            User user = olduser.get();
            user.setNickname(nickname.getNickname());
            _userRepository.save(user);
            return new ResponseEntity<User>(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE User
    public ResponseEntity<Object> deleteUser(@PathVariable String nickname){
        Optional<User> user = _userRepository.findByName(nickname);

        if(user.isPresent()){
            _userRepository.delete(user.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}