package com.ouyang.project.concurrent.temp;

import java.util.Random;

/**
 * Created by ouyang on 2017/10/10.
 */
public class MethodSync {
    protected int x;
    protected int y;
    protected final Random rng = new Random();  //引用不会被改变,不受加锁规则影响

    public MethodSync(int initialX, int initialY) {
        this.x = initialX;
        this.y = initialY;
    }

    public synchronized void syncMethod() throws Exception{
        x += rng.nextInt(10) - 5;
        y += rng.nextInt(20) - 10;
        String name = Thread.currentThread().getName();
        System.out.println("name:"+name+", method:syncMethod, content:x="+x+",y="+y);
        Thread.sleep(100L);
    }

    public void noSyncMethodStart() throws Exception{
        String name = Thread.currentThread().getName();
        System.out.println("name:"+name+", method:noSyncMethodStart");
    }

    public void noSyncMethodEnd() throws Exception{
        String name = Thread.currentThread().getName();
        System.out.println("name:"+name+", method:noSyncMethodEnd");
    }

}
