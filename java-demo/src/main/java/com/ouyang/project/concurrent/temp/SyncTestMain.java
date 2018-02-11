package com.ouyang.project.concurrent.temp;

/**
 * Created by ouyang on 2017/10/10.
 */
public class SyncTestMain {

    public static void testMethodSync() throws Exception {
        final MethodSync temp = new MethodSync(10, 10);
        final Runnable runnable = () -> {
            try {
                temp.noSyncMethodStart();
                temp.syncMethod();  //两个线程在执行此方法的时候为排队
                temp.noSyncMethodEnd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        Thread thread1 = new Thread(runnable, "first");
        Thread thread2 = new Thread(runnable, "second");
        thread1.start();
        thread2.start();
    }


    /**
     * 有时候结果如下
     name:first, method:noSyncMethodStart
     name:second, method:noSyncMethodStart
     name:first, method:syncMethod, content:x=10,y=18      第一个线程执行方法syncMethod
     name:second, method:syncMethod, content:x=10,y=21      第二个线程执行方法syncMethod
     name:second, method:syncBlockThis, syncBlock           第二个线程执行方法syncBlockThis块
     name:first, method:syncBlockThis, syncBlock            第一个线程执行方法syncBlockThis块
     name:second, method:syncBlockThis, content:x=10,y=21
     name:first, method:syncBlockThis, content:x=10,y=21    第一个线程被休眠了
     * @throws Exception
     */
    public static void testBlockSyncThis() throws Exception {
        final BlockSyncThis temp = new BlockSyncThis(10, 10);
        final Runnable runnable = () -> {
            try {
                temp.noSyncMethodStart();
                temp.syncMethod();  //两个线程在执行此方法的时候为排队
                temp.syncBlockThis();  //在块外first线程进行了等待,不阻塞second线程执行
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        Thread thread1 = new Thread(runnable, "first");
        Thread thread2 = new Thread(runnable, "second");
        thread1.start();
        thread2.start();
    }

    /**
     * 结果有时候是这样的 同步方法和同步块交替阻塞
     name:first, method:noSyncMethodStart
     name:second, method:noSyncMethodStart
     name:first, method:syncMethod, content:x=10,y=1    //第一个线程进入同步方法,阻塞
     name:second, method:syncMethod, content:x=12,y=-1  //第一个线程已释放,第二个线程进行同步方法,阻塞
     name:second, method:syncBlockThis, block start     //第二个线程进入同步块开始,阻塞
     name:second, method:syncBlockThis, block end       //第二个线程进入同步块结束
     name:first, method:syncBlockThis, block start      //第二个线程同步块释放,第一个线程进入同步块开始,阻塞
     name:second, method:syncBlockThis, content:x=12,y=-1   //第二个线程同步块方法结束
     name:first, method:syncBlockThis, block end        //第一个线程进入同步块结束
     name:first, method:syncBlockThis, content:x=12,y=-1    //第一个线程同步块方法结束
     * @throws Exception
     */
    public static void testBlockSyncThis2() throws Exception {
        final BlockSyncThis2 temp = new BlockSyncThis2(10, 10);
        final Runnable runnable = () -> {
            try {
                temp.noSyncMethodStart();
                temp.syncMethod();  //两个线程在执行此方法的时候为排队
                temp.syncBlockThis();  //块内内容进行了阻塞,进行排队等待,由于锁块为this,影响其他同步方法
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        Thread thread1 = new Thread(runnable, "first");
        Thread thread2 = new Thread(runnable, "second");
        thread1.start();
        thread2.start();
    }

    /**
     * 结果有时候是这样的 同步锁lock属性对象,阻塞锁这个对象的块
     name:first, method:noSyncMethodStart
     name:second, method:noSyncMethodStart
     name:first, method:syncMethod, content:x=8,y=12    //第一个线程进入同步方法,阻塞
     name:first, method:syncBlockField, block start     //第一个线程进入同步块开始,阻塞同步字段lock锁,不阻塞同步方法
     name:second, method:syncMethod, content:x=11,y=13  //第二个线程进入同步方法,阻塞
     name:first, method:syncBlockField, block end       //第一个线程进入同步块结束,阻塞同步字段lock锁,不阻塞同步方法
     name:second, method:syncBlockField, block start    //第二个线程进入同步块开始,阻塞同步字段lock锁,不阻塞同步方法
     name:first, method:syncBlockField, content:x=11,y=13   //第一个线程同步块,方法结束
     name:second, method:syncBlockField, block end      //第二个线程进入同步块结束,阻塞同步字段lock锁,不阻塞同步方法
     name:second, method:syncBlockField, content:x=11,y=13  //第二个线程同步块,方法结束
     * @throws Exception
     */
    public static void testBlockSyncField() throws Exception {
        final BlockSyncField temp = new BlockSyncField(10, 10);
        final Runnable runnable = () -> {
            try {
                temp.noSyncMethodStart();
                temp.syncMethod();  //两个线程在执行此方法的时候为排队
                temp.syncBlockField();  //块内内容进行了阻塞,进行排队等待,由于锁块字段lock,只影响lock块锁
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        Thread thread1 = new Thread(runnable, "first");
        Thread thread2 = new Thread(runnable, "second");
        thread1.start();
        thread2.start();
    }

    /**
     * 两个线程的方法交替执行  同一对象的同步方法互斥
     name:first, method:syncMethod1 start...
     name:first, method:syncMethod1 end...
     name:second, method:syncMethod2 start...
     name:second, method:syncMethod2 end...
     name:first, method:syncMethod2 start...
     name:first, method:syncMethod2 end...
     name:second, method:syncMethod1 start...
     name:second, method:syncMethod1 end...
     * @throws Exception
     */
    public static void testTwoMethodSync() throws Exception {
        final TwoMethodSync temp = new TwoMethodSync();
        Thread thread1 = new Thread(() -> {
            try {
                temp.syncMethod1();     //两个线程的方法交替执行
                Thread.sleep(10L);
                temp.syncMethod2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "first");
        Thread thread2 = new Thread(() -> {
            try {
                temp.syncMethod2();     //两个线程的方法交替执行  同一对象的同步方法互斥
                Thread.sleep(10L);
                temp.syncMethod1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "second");
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) throws Exception {
//        testMethodSync();
//        testBlockSyncThis();
//        testBlockSyncThis2();
//        testBlockSyncField();
        testTwoMethodSync();
    }
}
