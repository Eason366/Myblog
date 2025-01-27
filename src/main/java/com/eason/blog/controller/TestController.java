package com.eason.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@RestController
public class TestController {
    @Resource
    private RedisTemplate redisTemplate;
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);


    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }



    @RequestMapping("/redis/set/{key}/{value}")
    public String set(@PathVariable Long key, @PathVariable String value) {
        redisTemplate.opsForValue().set(key.toString(), value, 3600, TimeUnit.SECONDS);
        LOG.info("key: {}, value: {}", key, value);
        return "success";
    }

    @RequestMapping("/redis/get/{key}")
    public boolean get(@PathVariable Long key) {
        Object object = redisTemplate.opsForValue().get(key.toString());
        LOG.info("key: {}, value: {}", key, object);
//        return object;
        return object!=null;
    }
}
