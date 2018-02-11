package com.ouyang.project.concurrent.temp;

import java.util.Random;

/**
 * Created by ouyang on 2017/10/10.
 */
public class BlockSyncThis {

    protected int x;
    protected int y;
    protected final Random rng = new Random();  //引用不会被改变,不受加锁规则影响

    public BlockSyncThis(int initialX, int initialY) {
        this.x = initialX;
        this.y = initialY;
    }

    public void noSyncMethodStart() throws Exception{
        String name = Thread.currentThread().getName();
        System.out.println("name:"+name+", method:noSyncMethodStart");
    }

    public synchronized void syncMethod() throws Exception{
        x += rng.nextInt(10) - 5;
        y += rng.nextInt(20) - 10;
        Thread.sleep(10L);
        String name = Thread.currentThread().getName();
        System.out.println("name:"+name+", method:syncMethod, content:x="+x+",y="+y);
    }

    public void syncBlockThis() throws Exception{   //此方法不加锁,并发调用时不阻塞
        String name = Thread.currentThread().getName();
        int lx, ly;
        synchronized (this) {   //线程排队执行此段代码
            lx = this.x; ly = this.y;
            System.out.println("name:"+name+", method:syncBlockThis, syncBlock");
        }
        if("first".equals(name)) {  //只first线程进行了休眠
            Thread.sleep(100L);
        }
        System.out.println("name:"+name+", method:syncBlockThis, content:x="+lx+",y="+ly);
    }

}
