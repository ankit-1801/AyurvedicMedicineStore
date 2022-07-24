package com.ayurvedamedicine.controller;

import com.ayurvedamedicine.entities.User;
import com.ayurvedamedicine.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private IUserService iUserService;


    @PostMapping("/signUp")
    public ResponseEntity<User> createUser(@RequestBody User u) throws IOException {// changes
        return new ResponseEntity<>(iUserService.add(u), HttpStatus.OK);
    }
    @PostMapping("/signIn")
    public ResponseEntity<User> signIn(@RequestBody User u) throws IOException {// changes
    	return new ResponseEntity<>(iUserService.signIn(u), HttpStatus.CREATED);
    }
    @GetMapping("/readAll")
    public List<User> fetchingUser()
    {
        return iUserService.readAll();
    }

    @DeleteMapping( "/del/{userId}")
    private void deleteuser(@PathVariable("userId")Integer userId)
    {
        iUserService.delete(userId);
    }

    @GetMapping("/read/{userId}")
    public ResponseEntity<User>readuser(@PathVariable("userId")Integer userId)
    {
        return new ResponseEntity<>(iUserService.read(userId),HttpStatus.OK);
    }
    @PatchMapping("/update/{userId}")
    public ResponseEntity<String>updateUser(@PathVariable("userId")Integer userId,@RequestBody User user){
        return new ResponseEntity<>(iUserService.update(user,userId),HttpStatus.OK);
    }






}