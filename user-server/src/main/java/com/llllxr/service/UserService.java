package com.llllxr.service;

import com.llllxr.client.UserClient;
import com.llllxr.mapper.UserMapper;
import com.llllxr.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserClient {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(int id) {
        return userMapper.find(id);
    }
}
