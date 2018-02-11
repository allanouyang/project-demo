package com.ouyang.project.proxy.jdk;

import com.ouyang.project.proxy.IProxy;

/**
 * Created by ouyang on 2018/1/27.
 */
public class CommonProxyImpl implements IProxy {

    private IProxy proxy;

    public CommonProxyImpl(IProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public void queryCount() {
        System.out.println("queryCount事务处理之前");
        proxy.queryCount();
        System.out.println("queryCount事务处理之后");
    }

    @Override
    public void updateCount() {
        System.out.println("updateCount事务处理之前");
        proxy.updateCount();
        System.out.println("updateCount事务处理之前");
    }
}
