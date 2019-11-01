package com.imomei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Search搜索服务启动类
 */
@SpringBootApplication
@EnableEurekaClient
public class ServerSearchApp {
    public static void main(String[] args) {
        SpringApplication.run(ServerSearchApp.class, args);
    }
}
