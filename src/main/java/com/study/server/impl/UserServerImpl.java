package com.study.server.impl;

import com.study.dao.UserMapper;
import com.study.pojo.User;
import com.study.server.UserServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * Transactional 开启事务
     * @param user
     */
    @Override
    @Transactional
    public void insertUser(User user) {
        userMapper.insertUser(user);
        // 手动抛出异常
        throw new RuntimeException();
    }
}
