package com.ouyang.project.framework.scope;

import org.springframework.context.ApplicationContext;

/**
 * Created by ouyang on 2018/1/27.
 */
public class ScopeSampleRunnable implements Runnable {

    private ApplicationContext context;
    private int cnt = 0;

    public ScopeSampleRunnable(ApplicationContext context, int cnt) {
        this.context = context;
        this.cnt = cnt;
    }

    @Override
    public void run() {
        ScopeSampleBean bean = context.getBean(ScopeSampleBean.class);
        for(int i=0; i<cnt; i++) {
            bean.plus();
        }
        String threadName = Thread.currentThread().getName();
        System.out.println("thread:"+threadName+" 's count is "+bean.getValue());
    }
}
