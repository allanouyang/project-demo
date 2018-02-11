package com.ouyang.project.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by ouyang on 2018/1/27.
 */
public class JdkProxyFactoryBean {


    public static <T> T proxy(T t) {
        InvocationHandler handler = new JdkProxyInvocationHandler(t);
        T r = (T)Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), handler);
        return r;
    }
}
