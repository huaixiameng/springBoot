package com.study.controller;

import com.study.common.util.JsonResult;
import com.study.common.interceptor.UnInterception;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 拦截器
 */
@RestController
@RequestMapping("/interceptor")
public class InterceptorController {

    /**
     * UnInterception 通过自定义注解选择哪些接口不被拦截
     * @return
     */
    @GetMapping("/hello")
    @UnInterception
    public JsonResult hello() {
        return new JsonResult("拦截器测试");
    }
}
