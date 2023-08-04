package com.study.dao;

import com.study.pojo.User;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {

    /**
     * 基于xml
     * @param id
     * @return
     */
    User getUserById(String id);

    /**
     * 基于注解
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User getUser(String id);
}
