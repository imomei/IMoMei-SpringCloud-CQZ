package com.imomei.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ListenIMoMeiQueues {

    @RabbitListener(queues = "imomeiQueues1")
    private void getMsg1(String msg) {
        System.out.println("imomeiQueues1收到消息：" + new Date() + " = = = = = " + msg);
    }

    @RabbitListener(queues = "imomeiQueues2")
    private void getMsg2(String msg) {
        System.out.println("imomeiQueues2收到消息：" + new Date() + " = = = = = " + msg);
    }

    @RabbitListener(queues = "imomeiQueues3")
    private void getMsg3(String msg) {
        System.out.println("imomeiQueues3收到消息：" + new Date() + " = = = = = " + msg);
    }

}
