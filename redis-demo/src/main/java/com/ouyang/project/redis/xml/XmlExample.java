package com.ouyang.project.redis.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * Created by ouyang on 2017/2/24.
 */
public class XmlExample {

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<String, Object> opsValue;
    public void testWrite(){
        redisTemplate.opsForValue().set("xmlkey", "xmlvalue");
    }
    public void testRead(){
        System.out.println(redisTemplate.opsForValue().get("xmlkey"));
    }
}
