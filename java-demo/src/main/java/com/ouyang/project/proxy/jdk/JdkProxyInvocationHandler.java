package com.ouyang.project.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by ouyang on 2018/1/27.
 */
public class JdkProxyInvocationHandler implements InvocationHandler {

    private Object target;

    public JdkProxyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;
        String methodName = method.getName();
        System.out.println("方法:"+methodName+"调用前...");
        result = method.invoke(target, args);
        System.out.println("方法:"+methodName+"调用后...");
        return result;
    }
}
