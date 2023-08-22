package com.study.config.listen.OwnListen;

import com.study.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ListenService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;//注入spring事件发布者，用于发布事件

    public void createUser(User user) {
        log.info("发布事件开始");
        // TODO 1. 调用事件发布者发布事件,解耦
        applicationEventPublisher.publishEvent(new MyEvent(this, user));//发布事件。AfterCreateOrderEvent继承自ApplicationListener
        log.info("发布事件结束");
    }

    // TODO 2. 事件监听处理，加入@EventListener注解后，该方法可以看作事件监听者。参数就是自定义的事件。
    @EventListener
    public void afterCreateOrder(MyEvent myEvent) throws InterruptedException {
        log.info("自定义事件监听开始");
        User user = myEvent.getUser();
        Thread.sleep(2000);
        log.info("自定义事件监听" + user + "结束");
    }

}
