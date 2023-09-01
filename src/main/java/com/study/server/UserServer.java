package com.study.server;

import com.study.pojo.Student;

public interface UserServer {
    Student getUserById(String id);

    void insertUser(Student user);

    Student getUser();
}
