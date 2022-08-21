package com.markus.on.java.reflect.proxy;

import java.lang.reflect.Proxy;

/**
 * @author: markus
 * @date: 2022/8/20 10:58 PM
 * @Description: 动态代理
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class SimpleDynamicProxy {

    public static void consumer(Interface iFace) {
        iFace.doSomething();
        iFace.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        // 通过代理调用
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real)
        );
        consumer(proxy);
    }
}
