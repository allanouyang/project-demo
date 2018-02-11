package com.ouyang.project.framework.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by ouyang on 2018/1/28.
 */
@ComponentScan
public class LifeCycleApplication {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleApplication.class);
        context.registerShutdownHook();
        LifeCycleInterfaceService interfaceService = context.getBean(LifeCycleInterfaceService.class);
        LifeCycleAnnotationService annotationService = context.getBean(LifeCycleAnnotationService.class);
        annotationService.execute();
        interfaceService.execute();
//        context.start();
//        context.stop();
    }
}
