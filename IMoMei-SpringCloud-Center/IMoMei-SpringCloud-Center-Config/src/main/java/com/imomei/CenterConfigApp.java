package com.imomei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Config服务启动类
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class CenterConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(CenterConfigApp.class, args);
    }
}
