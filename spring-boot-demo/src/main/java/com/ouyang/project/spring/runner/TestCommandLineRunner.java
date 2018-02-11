package com.ouyang.project.spring.runner;

import com.ouyang.project.custom.CustomService;
import com.ouyang.project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

/**
 * Created by ouyang on 2017/12/22.
 */
@Component
@Priority(1)
public class TestCommandLineRunner implements CommandLineRunner {
    @Autowired
    private TestService testService;
    @Autowired
    private CustomService customService;

    @Override
    public void run(String... args) throws Exception {
        testService.hello();
        customService.hello();
    }
}
