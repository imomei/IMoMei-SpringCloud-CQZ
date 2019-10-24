package com.imomei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
@EnableEurekaClient
public class CenterSleuthApp {
    public static void main(String[] args) {
        SpringApplication.run(CenterSleuthApp.class, args);
    }
}
