package com.study.server.impl;

import com.study.dao.UserMapper;
import com.study.pojo.User;
import com.study.server.UserServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServerImpl implements UserServer {

    @Resource
    UserMapper userMapper;

    @Override
    public User getUserById(String id) {
        User user = userMapper.getUserById(id);
        User user1 = userMapper.getUser(id);
        return user1;
    }
}
