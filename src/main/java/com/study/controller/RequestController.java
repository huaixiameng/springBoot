package com.study.controller;

import com.study.pojo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/res")
public class RequestController {

    // http://localhost:8080/res/get
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String testGet() {
        return "success";
    }

    // http://localhost:8080/res/getUser/2/zhangsan
    @GetMapping("/getUser/{id}/{name}")
    public String testPathVariable(@PathVariable(value = "id") Integer id, @PathVariable String name) {
        System.out.println("获取到的id为：" + id);
        System.out.println("获取到的name为：" + name);
        return "success";
    }

    // http://localhost:8080/res/user?id=1
    @GetMapping("/getId")
    public String testRequestParam(@RequestParam(value = "id", required = false) Integer id) {
        System.out.println("获取到的id为：" + id);
        return "success";
    }

    @PostMapping("/user")
    public String testForm(@RequestBody Student user) {
        System.out.println("获取到的username为：" + user.getUsername());
        System.out.println("获取到的password为：" + user.getPassword());
        return "success";
    }


}
