package com.ouyang.project.custom.impl;

import com.ouyang.project.custom.CustomService;
import com.zxy.common.mapping.annotation.LogicHandler;
import com.zxy.common.mapping.annotation.LogicMapping;

import javax.annotation.PostConstruct;

/**
 * Created by ouyang on 2017/9/7.
 */
@LogicHandler
@LogicMapping("/custom")
public class CustomServiceImpl implements CustomService {

    @PostConstruct
    public void init() {
        System.out.println("init ...... ");
    }

    @Override
    @LogicMapping("/hello")
    public void hello() {
        System.out.println("hello, custom world!");
    }
}
