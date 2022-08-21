package com.markus.on.java.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/8/20 10:54 PM
 * @Description: 动态代理
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;// 被代理的对象

    public DynamicProxyHandler(Object obj) {
        proxied = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("***** proxy: " + proxy.getClass() + ", method: " + method + ", args: ");
        if (args != null) {
            for (Object arg : args) {
                System.out.println("  " + arg);
            }
        }
        return method.invoke(proxied, args);
    }
}
// 方法签名包括：方法名(包含全类名)+形参列表+返回值
