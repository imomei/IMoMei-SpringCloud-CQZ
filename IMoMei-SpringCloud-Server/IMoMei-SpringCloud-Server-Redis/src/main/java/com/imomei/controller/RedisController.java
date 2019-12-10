package com.imomei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    // 添加
    @RequestMapping(value = "/set")
    public String set(@RequestParam String key, @RequestParam String value) {
        if (!(StringUtils.isEmpty(key) && StringUtils.isEmpty(value))) {
            redisTemplate.opsForValue().set(key, value);
        }
        return "添加成功！";
    }

    // 查询
    @RequestMapping(value = "/get")
    public String get(@RequestParam String key) {
        String value = "";
        if (!StringUtils.isEmpty(key)) {
            value = redisTemplate.opsForValue().get(key).toString();
        }
        return value;
    }



}
