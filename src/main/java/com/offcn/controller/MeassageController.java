package com.offcn.controller;

import com.offcn.service.MessageConsumer;
import com.offcn.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeassageController {
    @Autowired
    MessageProducer messageProducer;

    @RequestMapping("/rabbit.action")
    public String messageGet(){
        System.out.println("wewewewe");
        messageProducer.sendMessage("Hello world");
        return "test";
    }
}
