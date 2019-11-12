package com.imomei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/get")
    public String set() {
        redisTemplate.opsForValue().set("a1", "123");
        redisTemplate.opsForValue().set("中文key", "中文value");
        return "添加成功！";
    }

    @RequestMapping
    public String get() {
        return "";
    }
}
