package com.study.controller;

import com.study.config.JsonResult;
import com.study.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:8080/swagger-ui.html#/
 */
@RestController
@RequestMapping("/swagger")
@Api(value = "Swagger2 在线接口文档")
public class SwaggerController {

    @GetMapping("/get/{id}")
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    public JsonResult getUserInfo(@PathVariable @ApiParam(value = "用户唯一标识") int id) {
        // 模拟数据库中根据id获取User信息
        User user = new User(id, "HuaiMeng", "123456");
        return new JsonResult(user);
    }
}
