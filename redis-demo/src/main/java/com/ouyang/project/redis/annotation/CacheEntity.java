package com.ouyang.project.redis.annotation;

import java.io.Serializable;

/**
 * Created by ouyang on 2017/4/28.
 */
public class CacheEntity implements Serializable {
    private String id;
    private String name;

    public CacheEntity(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
