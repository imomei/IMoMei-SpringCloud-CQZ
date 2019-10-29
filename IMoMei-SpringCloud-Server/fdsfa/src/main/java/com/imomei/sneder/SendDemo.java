package com.imomei.sneder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendDemo {

    Logger log = LoggerFactory.getLogger(Object.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "/sendMsg")
    public String sendMsg(String key) {
        rabbitTemplate.convertAndSend("imomeiTopic", key, "消息");
        return "发完消息了";
    }

    private static int count = 0;

    @Scheduled(cron = "* * * * * *")
    public void timeSout() {
        System.out.println("定时任务，每秒触发：" + count++);
    }
    
}