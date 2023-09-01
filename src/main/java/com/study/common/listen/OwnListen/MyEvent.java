package com.study.common.listen.OwnListen;

import com.study.pojo.Student;
import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * @author shengwu ni
 * @date 2018/07/05
 */
public class MyEvent extends ApplicationEvent {

    private Student user;

    public MyEvent(Object source, Student user) {
        super(source);
        this.user = user;
    }

    public Student getUser() {
        return user;
    }

    public void setUser(Student user) {
        this.user = user;
    }
}
