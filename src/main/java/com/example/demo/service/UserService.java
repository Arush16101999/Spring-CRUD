package com.example.demo.service;


import com.example.demo.model.AppUser;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<AppUser> getAllUsers(){
        return userRepository.findAll();
    }

    public AppUser saveUser(AppUser user){
        return userRepository.save(user);
    }

    public Optional<AppUser> getUserById(Long id){
        return userRepository.findById(id);
    }

    public AppUser updateUser(Long id,AppUser userDetails){
        AppUser appUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("NO user Found"));

        appUser.setName(userDetails.getName());
        appUser.setEmail(userDetails.getEmail());
        return userRepository.save(appUser);
    }

    public void deleteUser(Long id){
        AppUser appUser = userRepository.findById(id).orElseThrow(()-> new RuntimeException("NO User"));

        userRepository.delete(appUser);
    }
}
