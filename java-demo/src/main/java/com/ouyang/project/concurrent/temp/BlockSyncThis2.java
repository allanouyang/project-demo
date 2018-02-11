package com.ouyang.project.concurrent.temp;

/**
 * Created by ouyang on 2017/10/10.
 */
public class BlockSyncThis2 extends BlockSyncThis {
    public BlockSyncThis2(int initialX, int initialY) {
        super(initialX, initialY);
    }

    public void syncBlockThis() throws Exception{   //此方法并发调用,不阻塞
        String name = Thread.currentThread().getName();
        int lx, ly;
        //线程排队执行此段代码,由于锁住this对象,影响其他同步方法syncMethod()
        synchronized (this) {
            lx = this.x; ly = this.y;
            System.out.println("name:"+name+", method:syncBlockThis, block start");
            Thread.sleep(100L);
            System.out.println("name:"+name+", method:syncBlockThis, block end");
        }
        System.out.println("name:"+name+", method:syncBlockThis, content:x="+lx+",y="+ly);
    }
}
