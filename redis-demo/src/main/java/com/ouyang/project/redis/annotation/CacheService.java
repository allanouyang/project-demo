package com.ouyang.project.redis.annotation;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by ouyang on 2017/4/28.
 */
@Service
public class CacheService {

    @Cacheable(cacheNames = "test-cache", key = "#id")
    public CacheEntity getCacheEntity(String id){
        System.out.println("call CacheService.getCacheEntity()..........");
        CacheEntity cacheEntity = new CacheEntity("1002", "cache10020");
        return cacheEntity;
    }

    @CachePut(cacheNames = "test-cache", key = "#cacheEntity.id")
    public CacheEntity setCacheEntity(CacheEntity cacheEntity){
        return cacheEntity;
    }

    @CacheEvict(cacheNames = "test-cache", key = "#id")
    public void removeCacheEntity(String id){
    }
}
