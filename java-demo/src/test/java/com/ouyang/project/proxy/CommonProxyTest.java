package com.ouyang.project.proxy;

import com.ouyang.project.proxy.jdk.CommonProxyImpl;
import org.junit.Test;

/**
 * Created by ouyang on 2018/1/27.
 */
public class CommonProxyTest {

    @Test
    public void testQueryCount() {
        IProxy proxy = new CommonProxyImpl(new ProxyImpl());
        proxy.queryCount();
    }

    @Test
    public void testUpdateCount() {
        IProxy proxy = new CommonProxyImpl(new ProxyImpl());
        proxy.updateCount();
    }

}
