package com.ouyang.project.framework.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by ouyang on 2018/1/28.
 */
@Service
public class LifeCycleAnnotationService {

    @Autowired
    private ApplicationContext context;

//    @Autowired
//    public void setApplicationContext(ApplicationContext context) {
//        this.context = context;
//    }

    @PostConstruct
    public void init() {
        System.out.println("LifeCycleAnnotationService's init method ...... ");
    }

    public void execute() {
        LifeCycleInterfaceService interfaceService = context.getBean(LifeCycleInterfaceService.class);
        interfaceService.testAutoWiredApplication();
        System.out.println("LifeCycleAnnotationService's execute method ...... ");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("LifeCycleAnnotationService's destroy method ...... ");
    }
}
