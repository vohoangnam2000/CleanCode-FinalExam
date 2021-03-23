package com.example.demo.Controller;

import com.example.demo.Entity.Users;
import com.example.demo.Service.UserSerrvice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    public UserSerrvice userSerrvice;
    @ResponseBody
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUser(){
        List<Users> users= userSerrvice.getListUser();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(users);
        } catch (Exception e) {
            return "{'error': 'cannot return books'}";
        }
    }
}
