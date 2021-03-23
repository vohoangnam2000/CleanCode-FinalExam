package com.example.demo.Service;

import com.example.demo.Entity.Users;
import com.example.demo.Reponsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSerrvice {
    @Autowired
    public UserRepository userRepository;

    public List<Users> getListUser(){
        List<Users> users = userRepository.findAll();
        return users;
    }

}
