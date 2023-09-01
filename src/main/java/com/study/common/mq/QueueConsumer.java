package com.study.common.mq;

import com.study.common.config.ActiveMqConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * 消息消费者
 * @author shengwu ni
 */
//@Service
public class QueueConsumer {

    /**
     * 接收点对点消息
     * @param msg
     */
    @JmsListener(destination = ActiveMqConfig.QUEUE_NAME)
    public void receiveQueueMsg(String msg) {
        System.out.println("queue点对点：" + msg);
    }
}
