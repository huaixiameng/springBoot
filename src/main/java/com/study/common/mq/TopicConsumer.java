package com.study.common.mq;

import com.study.common.config.ActiveMqConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * Topic消息消费者
 * @author shengwu ni
 */
//@Service
public class TopicConsumer {

    /**
     * 接收订阅消息
     * @param msg
     */
    @JmsListener(destination = ActiveMqConfig.TOPIC_NAME, containerFactory = "topicListenerContainer")
    public void receiveTopicMsg(String msg) {
        System.out.println("topic收到的消息为：" + msg);
    }

}
