package com.imomei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/***
 * Member启动类
 */
@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
@MapperScan("com.imomei.mapper")
public class ServerMemberApp {
    public static void main(String[] args) {
        SpringApplication.run(ServerMemberApp.class, args);
    }
}
