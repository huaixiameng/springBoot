package com.study.config.listen;

import com.study.pojo.User;
import com.study.server.UserServer;
import com.study.server.impl.UserServerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

/**
 * 可以进行数据预加载，在项目启动时就会进行处理
 * 使用ApplicationListener来初始化一些数据到application域中的监听器
 */
@Component
public class ApplicationListen implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // 先获取到application上下文
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        // 获取对应的service
        UserServer userServer = applicationContext.getBean(UserServerImpl.class);
        User user = userServer.getUser();
        // 获取application域对象，将查到的信息放到application域中
        ServletContext application = applicationContext.getBean(ServletContext.class);
        application.setAttribute("userApplication", user);
    }
}