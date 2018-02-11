package com.ouyang.project.spring.runner;

import com.zxy.common.mapping.support.LogicMappingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

/**
 * Created by ouyang on 2017/12/22.
 */
@Component
@Priority(2)
public class TestApplicationRunner implements ApplicationRunner {

    @Autowired
    private LogicMappingHandler handler;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("use method by logic mapping ...... ");
        handler.invoke("/custom/hello", new Object[]{});
    }
}
