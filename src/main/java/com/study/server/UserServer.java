package com.study.server;

import com.study.pojo.User;

public interface UserServer {
    User getUserById(String id);

    void insertUser(User user);

    User getUser();
}
