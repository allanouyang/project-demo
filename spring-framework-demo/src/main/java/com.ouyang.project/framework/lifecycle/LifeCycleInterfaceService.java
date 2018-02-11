package com.ouyang.project.framework.lifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Service;

/**
 * Created by ouyang on 2018/1/28.
 */
@Service
public class LifeCycleInterfaceService implements InitializingBean, DisposableBean, Lifecycle, BeanNameAware {

    private String name;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("LifeCycleInterfaceService's destroy method ...... ");
    }

    public void execute() {
        System.out.println("LifeCycleInterfaceService's execute method ...... ");
        System.out.println("name is " + name + "......");
    }

    public void testAutoWiredApplication() {
        System.out.println("LifeCycleInterfaceService's testAutoWiredApplication method ...... ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("LifeCycleInterfaceService's afterPropertiesSet method ...... ");
    }

    @Override
    public void start() {
        System.out.println("start ...... ");
    }

    @Override
    public void stop() {
        System.out.println("stop ...... ");
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
