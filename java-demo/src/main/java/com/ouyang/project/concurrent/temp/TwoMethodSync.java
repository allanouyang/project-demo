package com.ouyang.project.concurrent.temp;

/**
 * Created by ouyang on 2017/10/11.
 */
public class TwoMethodSync {

    public synchronized void syncMethod1() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println("name:"+name+", method:syncMethod1 start... ");
        Thread.sleep(100L);
        System.out.println("name:"+name+", method:syncMethod1 end... ");
    }

    public synchronized void syncMethod2() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println("name:"+name+", method:syncMethod2 start... ");
        Thread.sleep(100L);
        System.out.println("name:"+name+", method:syncMethod2 end... ");
    }
}
