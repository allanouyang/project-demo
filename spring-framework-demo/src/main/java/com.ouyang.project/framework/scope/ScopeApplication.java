package com.ouyang.project.framework.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by ouyang on 2018/1/27.
 */
@ComponentScan
public class ScopeApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ScopeApplication.class);
        for(int i=5; i<=10; i++) {
            Thread t = new Thread(new ScopeSampleRunnable(context, i));
            t.setName("thread"+i);
            t.start();
        }
    }

}
