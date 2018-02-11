package com.ouyang.project.framework.custom;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by ouyang on 2018/1/28.
 */
@ComponentScan
public class CustomApplication {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new CustomBeanPostProcessorReg());
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(beanFactory);
        context.register(CustomApplication.class);
        context.refresh();
//        ApplicationContext context = new AnnotationConfigApplicationContext(CustomApplication.class);
//        beanFactory.addBeanPostProcessor(new CustomBeanPostProcessorReg());
//        ((AbstractApplicationContext) context).registerShutdownHook();
    }
}
