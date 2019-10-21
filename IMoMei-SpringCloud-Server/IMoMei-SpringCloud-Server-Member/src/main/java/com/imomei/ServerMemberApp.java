package com.imomei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/***
 * Member启动类
 */
@SpringBootApplication
@EnableEurekaClient
public class ServerMemberApp {
    public static void main(String[] args) {
        SpringApplication.run(ServerMemberApp.class, args);
    }
}
