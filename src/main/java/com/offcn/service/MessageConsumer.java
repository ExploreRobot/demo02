package com.offcn.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class MessageConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("消息出队"+message);
    }
}