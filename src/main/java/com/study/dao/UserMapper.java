package com.study.dao;

import com.study.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {

    /**
     * 基于xml
     * @param id
     * @return
     */
    Student getUserById(String id);

    /**
     * 基于注解
     * @param id
     * @return
     */
    @Select("select * from student where id = #{id}")
    Student getUser(String id);

    @Insert("insert into student (username, password) values (#{username}, #{password})")
    Integer insertUser(Student user);
}
