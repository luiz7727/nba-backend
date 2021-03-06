package com.example.nbabackend.Service;

import com.example.nbabackend.Model.User;
import com.example.nbabackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository _userRepository;

    //getting all users
    public List<User> getAllUsers(){
        return _userRepository.findAll();
    }

    //create a new user
    public User createNewUser(@RequestBody User user){

        return _userRepository.save(user);

    }

    //Get User By id
    public ResponseEntity<User> getById(@PathVariable String nickname){

        Optional<User> user = _userRepository.findByNickname(nickname);

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

        Optional<User> olduser = _userRepository.findByNickname(nicknamePath);

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
        Optional<User> user = _userRepository.findByNickname(nickname);

        if(user.isPresent()){
            _userRepository.delete(user.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //verificando se o usu??rio j?? foi cadastrado
    public HttpStatus userAlreadyCreated(@PathVariable String user){

        Optional<User> userCreated = _userRepository.findByNickname(user);

        HttpStatus userResponseCreated = null;

        if(userCreated.isPresent()){

            userResponseCreated = HttpStatus.CREATED;
        }

        return userResponseCreated;
    }

    public ResponseEntity<User> putUserCardInfo (@PathVariable String nickname,@RequestBody User newInfoCardUser){

        Optional<User> userNickname = _userRepository.findByNickname(nickname);

        if (userNickname.isPresent()){

            User newInfos = userNickname.get();
            newInfos.setCardName(newInfoCardUser.getCardName());
            newInfos.setCardNumber(newInfoCardUser.getCardNumber());
            newInfos.setCardCvv(newInfoCardUser.getCardCvv());

            return new ResponseEntity<User>(newInfos,HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
