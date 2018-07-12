package com.offcn.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MessageProducer {
    @Resource
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Object message) {
        //logger.info("to send message:{}", message);
        System.out.println("消息入队："+message);
        amqpTemplate.convertAndSend("queueTestKey", message);
    }
}
