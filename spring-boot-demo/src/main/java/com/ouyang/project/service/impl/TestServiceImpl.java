package com.ouyang.project.service.impl;

import com.ouyang.project.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by ouyang on 2017/9/7.
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public void hello() {
        System.out.println("hello, world!");
    }
}
