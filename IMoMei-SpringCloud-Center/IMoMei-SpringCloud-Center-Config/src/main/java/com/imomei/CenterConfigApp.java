package com.imomei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CenterConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(CenterConfigApp.class, args);
    }
}
