package com.ouyang.project.proxy;

/**
 * Created by ouyang on 2018/1/27.
 */
public class ProxyImpl implements IProxy {

    @Override
    public void queryCount() {
        System.out.println("查看账户方法...");
    }

    @Override
    public void updateCount() {
        System.out.println("修改账户方法...");
    }
}
