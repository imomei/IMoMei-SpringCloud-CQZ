package com.imomei.listen;

import com.imomei.controller.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MQListener {

    @RabbitListener(queues = {"imomeiQueues1"})
    private void getMsg1(String msg) {
        System.out.println("队列一收到消息：" + msg);
    }

    @RabbitListener(queues = {"imomeiQueues2"})
    private void getMsg2(String msg) {
        System.out.println("队列二收到消息：" + msg);
    }
}
