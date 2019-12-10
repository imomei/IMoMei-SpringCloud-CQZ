package com.imomei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/***
 * Zuul服务端启动类
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class CenterZuulApp {
    public static void main(String[] args) {
        SpringApplication.run(CenterZuulApp.class, args);
    }
}
