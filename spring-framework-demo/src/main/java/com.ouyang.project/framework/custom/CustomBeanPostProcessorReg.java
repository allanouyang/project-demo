package com.ouyang.project.framework.custom;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by ouyang on 2018/1/28.
 */
public class CustomBeanPostProcessorReg implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomBeanPostProcessorReg.postProcessBeforeInitialization execute ...... " + bean.getClass().getName());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomBeanPostProcessorReg.postProcessAfterInitialization execute ...... " + bean.getClass().getName());
        return bean;
    }
}
