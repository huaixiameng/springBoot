package com.study.controller;

import com.study.common.listen.OwnListen.ListenService;
import com.study.pojo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/listener")
public class ListenerController {
    /**
     * 获取application上下文数据
     * @param request
     * @return
     */
    @GetMapping("/user")
    public Student getUser(HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        return (Student) application.getAttribute("userApplication");
    }

    /**
     * session监听器  获取当前在线人数
     * @param request
     * @return
     */
    @GetMapping("/total")
    public String getTotalUser(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie;
        try {
            // 把sessionId记录在浏览器中
            cookie = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(), "utf-8"));
            cookie.setPath("/");
            //设置cookie有效期为2天，设置长一点
            cookie.setMaxAge( 48*60 * 60);
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数：" + count;
    }

    /**
     * 监听http请求
     * @param request
     * @return
     */
    @GetMapping("/request")
    public String getRequestInfo(HttpServletRequest request) {
        System.out.println("http监听的的name数据：" + request.getAttribute("nameSession"));
        return "success";
    }


    @Resource
    private ListenService listenService;
    /**
     * 自定义监听器
     * 1、自定义事件需要继承 ApplicationEvent 对象
     * 2、自定义一个监听器来监听上面定义的 MyEvent 事件
     * 3、手动发布事件
     * 4、在 service 中注入 ApplicationContext 在业务代码处理完之后，通过 ApplicationContext 对象手动发布 MyEvent 事件
     * @param request
     * @return
     */
    @GetMapping("/request2")
    public String getRequestInfo2(HttpServletRequest request) {
        Student user = new Student("1","sun","1234567");
        listenService.createUser(user);
        return "success";
    }

}


