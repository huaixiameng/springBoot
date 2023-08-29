package com.study.controller;

import com.study.common.mq.MsgProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * pom文件，yam文件，activeMQConfig配置，msgProducer消息生产者，queueConsumer点对点消费者，topicConsumer订阅消费者
 * 点对点，用完及消耗，只支持一个消费者；订阅 ，用完不消耗，支持多个消费者
 * @author
 */
@RestController
@RequestMapping("/activemq")
public class ActiveMqController {

    private static final Logger logger = LoggerFactory.getLogger(ActiveMqController.class);

    @Resource
    private MsgProducer producer;

    @Resource
    private Destination queue; //固定名称

    @Resource
    private Destination topic;//固定名称


    @GetMapping("/send/queue")
    public String sendQueueMessage() {

        logger.info("===开始发送点对点消息===");
        producer.sendMessage(queue, "Queue: hello activemq!");
        return "success";
    }

    @GetMapping("/send/topic")
    public String sendTopicMessage() {

        logger.info("===开始发送订阅消息===");
        producer.sendMessage(topic, "Topic: hello activemq!");
        return "success";
    }

}