package com.cxp.sbt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/test1")
public class RedisTest {

    @Autowired
    private StringRedisTemplate srt;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @RequestMapping("/getredis")
    @ResponseBody
    public String getString() {

        srt.opsForValue().set("测试redis", "成功1111");
        return srt.opsForValue().get("测试redis");

    }

    /*
     * springdata使用redisTemplate操作redis
     * 操作字符串类型
     * */
    @RequestMapping("/testString")
    @ResponseBody
    public String testString() {
        //设置值
        redisTemplate.opsForValue().set("springbootkey1", "你好redisTemplate", 1, TimeUnit.MINUTES);
        redisTemplate.opsForValue().set("springbootkey2", "redistemplate2", 1, TimeUnit.MINUTES);

        //获取多个数据值
        List<String> lists = redisTemplate.opsForValue().multiGet(Arrays.asList("springbootkey1", "springbootkey2"));
        //获取单个值
        redisTemplate.opsForValue().get("springbootkey1");

        return lists.toString();
    }

    /*
     * springdata使用redisTemplate操作redis
     * 操作list数据
     * */
    @RequestMapping("/testList")
    @ResponseBody
    public String testList() {
        //设置值
        redisTemplate.opsForList().leftPush("list1", "你好redisTemplate");
        redisTemplate.opsForList().leftPush("list2", "22", "11");

        //获取多个数据值
        List<String> lists = redisTemplate.opsForValue().multiGet(Arrays.asList("springbootkey1", "springbootkey2"));
        //获取单个值
        redisTemplate.opsForValue().get("springbootkey1");

        return lists.toString();
    }
}
