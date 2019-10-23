package com.imomei.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/sendMsg")
    public String sendMsg(String key) {
        rabbitTemplate.convertAndSend("imomeiTopic", key, "消息");
        return "发完消息了";
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = "cqz19960117";
        String passwordBC1 = bCryptPasswordEncoder.encode(password);
        String passwordBC2 = bCryptPasswordEncoder.encode(password);
        boolean result1 = bCryptPasswordEncoder.matches(password, passwordBC1);
        boolean result2 = bCryptPasswordEncoder.matches(password, passwordBC2);
        System.out.println("加密后密码：" + passwordBC1);
        System.out.println("加密后密码：" + passwordBC2);
        System.out.println("比对结果：" + result1);
        System.out.println("比对结果：" + result2);
    }
}
