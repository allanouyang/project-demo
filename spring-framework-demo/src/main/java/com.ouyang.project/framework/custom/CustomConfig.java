package com.ouyang.project.framework.custom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ouyang on 2018/1/29.
 */
@Configuration
public class CustomConfig {

    @Bean
    public OtherService otherService() {
        return new OtherService();
    }
}
