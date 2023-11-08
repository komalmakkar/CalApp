package com.example.helloworld.controller;

import com.example.helloworld.Interfaces.IUserService;
import com.example.helloworld.models.User;
import com.example.helloworld.models.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController

public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> user(@PathVariable  UUID id){
        return new ResponseEntity<User>( this.userService.getUser(id), HttpStatus.OK);
    }
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> user(){
        return new ResponseEntity<List<User>>(this.userService.getAllUsers(), HttpStatus.OK);
    }
    @PutMapping("/user")
    public ResponseEntity<User> user(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<User>( this.userService.addOrUpdateUser(userRequest), HttpStatus.OK);
    }
}
