package com.ouyang.project.redis.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by ouyang on 2017/2/24.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.ouyang.project.redis.annotation"})
@EnableCaching
public class RedisBootApplication implements CommandLineRunner{

    @Autowired
    private CacheService cacheService;

    public CacheService getCacheService(){
        return cacheService;
    }

    @Override
    public void run(String... strings) throws Exception {

//        cacheService.setCacheEntity(new CacheEntity("1002", "cache1002"));
//        cacheService.removeCacheEntity("1002");
        System.out.println(cacheService.getCacheEntity("1002").getName());
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisBootApplication.class);
    }
}
