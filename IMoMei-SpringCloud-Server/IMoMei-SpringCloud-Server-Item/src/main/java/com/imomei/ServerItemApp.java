package com.imomei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Item服务启动类：MySQL、Redis
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.imomei.mapper")
public class ServerItemApp {
    public static void main(String[] args) {
        SpringApplication.run(ServerItemApp.class, args);
    }
}