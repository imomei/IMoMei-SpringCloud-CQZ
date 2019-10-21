package com.imomei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/***
 * Eureka服务端启动类
 */
@SpringBootApplication
@EnableEurekaServer
public class CenterEurekaApp {
    public static void main(String[] args) {
        SpringApplication.run(CenterEurekaApp.class, args);
    }
}
