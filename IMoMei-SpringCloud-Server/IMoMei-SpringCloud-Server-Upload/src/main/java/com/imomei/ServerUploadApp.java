package com.imomei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Upload文件上传服务启动类
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.imomei.mapper")
public class ServerUploadApp {
    public static void main(String[] args) {
        SpringApplication.run(ServerUploadApp.class, args);
    }
}