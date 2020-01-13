package com.imomei;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * MQ服务启动类：MQ
 */
@SpringBootApplication
@EnableEurekaClient
@EnableRabbit
public class ServerMQApp {
    public static void main(String[] args) {
        SpringApplication.run(ServerMQApp.class, args);
    }
}