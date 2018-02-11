package com.ouyang.project.concurrent.thread;

/**
 * Created by ouyang on 2018/2/7.
 */
public class ThreadBase {

    public void testIsAlive() {
        Thread t1 = new Thread(() -> {
            for(int i=0; i<10; i++) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("sleep"+i+"......");
            }
        });
        t1.start();
        for(int i=0; i<12; i++) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread isAlive value is : " + t1.isAlive());
        }
        t1.start();
    }

    public void testRepeatStart() {

    }
}
