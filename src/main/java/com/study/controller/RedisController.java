package com.study.controller;

import com.study.common.util.JsonResult;
import com.study.common.util.RedisUtil;
import com.study.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {

    @Resource
    private RedisUtil redisUtil;


    @GetMapping("/hello")
    public JsonResult hello() {

        //redisUtil.setString("name","sun");
        log.info("String存储字符串 {}",redisUtil.getString("name"));

        Student user = new Student("1","ss","7634");
        //redisUtil.setString("user", JSON.toJSONString(user));
        log.info("String存储对象 {}",redisUtil.getString("user"));

        //redisUtil.setHash("order", "user1", JSON.toJSONString(user));
        //redisUtil.setHash("order", "user2", JSON.toJSONString(user));
        log.info("hash类型：{}", redisUtil.getHash("order","user1"));
        log.info("hash类型：{}", redisUtil.getHash("order","user2"));


        //测试redis的list类型
//        redisUtil.setList("list", "football");
//        redisUtil.setList("list", "basketball");
        List<String> valList = redisUtil.getList("list",0,-1);
        for(String value :valList){
            log.info("list中有：{}", value);
        }

        return new JsonResult().success();
    }


}
