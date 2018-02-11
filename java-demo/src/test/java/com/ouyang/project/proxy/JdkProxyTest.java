package com.ouyang.project.proxy;

import com.ouyang.project.proxy.jdk.JdkProxyFactoryBean;
import org.junit.Test;

/**
 * Created by ouyang on 2018/1/27.
 */
public class JdkProxyTest {

    @Test
    public void testQueryCount() {
        IProxy proxy = JdkProxyFactoryBean.proxy(new ProxyImpl());
        proxy.queryCount();
    }

    @Test
    public void testUpdateCount() {
        IProxy proxy = JdkProxyFactoryBean.proxy(new ProxyImpl());
        proxy.updateCount();
    }

}
