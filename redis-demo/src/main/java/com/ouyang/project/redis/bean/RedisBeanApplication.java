package com.ouyang.project.redis.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by ouyang on 2017/2/24.
 */
@Configuration
@ComponentScan
public class RedisBeanApplication {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RedisBeanApplication.class);
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set("key2", "测试一下");
    }
}
