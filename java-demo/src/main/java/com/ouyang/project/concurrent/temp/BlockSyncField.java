package com.ouyang.project.concurrent.temp;

/**
 * Created by ouyang on 2017/10/10.
 */
public class BlockSyncField extends BlockSyncThis {

    private final Object lock = new Object();    //用于加锁

    public BlockSyncField(int initialX, int initialY) {
        super(initialX, initialY);
    }

    public void syncBlockField() throws Exception{   //此方法并发调用,不阻塞
        String name = Thread.currentThread().getName();
        int lx, ly;
        //线程排队执行此段代码,由于锁住this对象,影响其他同步方法syncMethod()
        synchronized (lock) {
            lx = this.x; ly = this.y;
            System.out.println("name:"+name+", method:syncBlockField, block start");
            Thread.sleep(100L);
            System.out.println("name:"+name+", method:syncBlockField, block end");
        }
        System.out.println("name:"+name+", method:syncBlockField, content:x="+lx+",y="+ly);
    }
}
