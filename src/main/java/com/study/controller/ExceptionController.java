package com.study.controller;

import com.study.config.JsonResult;
import com.study.exception.ErrorException;
import com.study.exception.CodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/except")
public class ExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);


    /**
     * 测试缺少参数异常
     * @param name
     * @param pass
     * @return
     */
    @PostMapping("/except")
    public JsonResult test(@RequestParam("name") String name,
                           @RequestParam("pass") String pass) {
        logger.info("name：{}", name);
        logger.info("pass：{}", pass);
        return new JsonResult();
    }

    /**
     * 自定义异常抛出
     * @return
     */
    @GetMapping("/business")
    public JsonResult testException() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new ErrorException(CodeEnum.UNEXPECTED_EXCEPTION);
        }
        return new JsonResult();
    }

}
