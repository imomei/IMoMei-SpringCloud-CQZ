package com.imomei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Video视频服务启动类
 */
@SpringBootApplication
@EnableEurekaClient
public class ServerVideoApp {
    public static void main(String[] args) {
        SpringApplication.run(ServerVideoApp.class, args);
    }
}
