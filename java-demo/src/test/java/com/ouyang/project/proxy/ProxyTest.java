package com.ouyang.project.proxy;

import org.junit.Test;

/**
 * Created by ouyang on 2018/1/27.
 */
public class ProxyTest {

    @Test
    public void testQueryCount() {
        IProxy proxy = new ProxyImpl();
        proxy.queryCount();
    }

    @Test
    public void testUpdateCount() {
        IProxy proxy = new ProxyImpl();
        proxy.updateCount();
    }

}
