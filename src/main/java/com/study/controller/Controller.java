package com.study.controller;

import com.study.config.JsonResult;
import com.study.config.MicroServiceUrl;
import com.study.pojo.User;
import com.study.server.UserServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sun")
public class Controller {

    private final static Logger logger = LoggerFactory.getLogger(Controller.class);

    @Resource
    private MicroServiceUrl microServiceUrl;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private UserServer userService;

    @GetMapping("/hello")
    public String hello() {
        return String.format("端口号: %s!", serverPort);
    }

    @RequestMapping("/getUserById/{id}")
    public JsonResult getUserById(@PathVariable String id) {
        return new JsonResult(userService.getUserById(id));
    }

    @PostMapping("/insertUser")
    public JsonResult insertUser(@RequestBody User user) {
        userService.insertUser(user);
        return new JsonResult().success();
    }

    /**
     * 日志测试
     * @return
     */
    @GetMapping("/log")
    public String index() {

        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");

        // 可以使用占位符打印出一些参数信息
        String str1 = "HuaiMeng";
        String str2 = "15";
        logger.info("姓名：{}；性别：{}", str1, str2);
        return "Greetings from Spring Boot!";
    }

    /**
     * 配置类，需要引入依赖
     *
     * @return str
     */
    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public String testConfig() {
        logger.info("=====获取的订单服务地址为：{}", microServiceUrl.getOrderUrl());
        logger.info("=====获取的用户服务地址为：{}", microServiceUrl.getUserUrl());
        logger.info("=====获取的购物车服务地址为：{}", microServiceUrl.getShoppingUrl());

        return "success";
    }

}
