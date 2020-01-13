package com.imomei.controller;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MQController {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    private final String EXCHANGE_TOPIC = "imomei_test_topic";
    private final String ROUTINGKEY_TOPIC = "imomei.test.topic1";

    @RequestMapping("/sendMsg")
    public String sendMsg(String msg) {
        rabbitTemplate.convertAndSend(EXCHANGE_TOPIC, ROUTINGKEY_TOPIC, new User(msg, "123").toString());
        return "投递成功";
    }

}
