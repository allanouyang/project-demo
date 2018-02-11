package com.ouyang.project.redis.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ouyang on 2017/2/24.
 */
public class RedisXmlApplication {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
        XmlExample xmlExample = (XmlExample)context.getBean("xmlExample");
        xmlExample.testWrite();
        xmlExample.testRead();
    }
}
