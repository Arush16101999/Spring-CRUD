package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<AppUser> getAllUser(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<AppUser> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppUser createUser(@RequestBody AppUser user){
        return  userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public AppUser updateUser(@PathVariable Long id, @RequestBody AppUser userDetails){
        return userService.updateUser(id,userDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    } // by using void it won't return data from the method

}
