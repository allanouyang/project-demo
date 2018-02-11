package com.ouyang.project.framework.custom;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by ouyang on 2018/1/28.
 */
@Service
public class CustomService {

    @PostConstruct
    void init(){
        System.out.println("init......");
    }
}
