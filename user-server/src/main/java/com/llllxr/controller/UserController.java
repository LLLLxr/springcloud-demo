package com.llllxr.controller;

import com.llllxr.pojo.User;
import com.llllxr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") int id){
//        int x = 3/0;
        User user = userService.findUserById(id);
        return user;
    }
}