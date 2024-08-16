package com.llllxr.service;

import com.llllxr.mapper.UserMapper;
import com.llllxr.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(Integer id) {
        return userMapper.find(id);
    }
}
