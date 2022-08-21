package com.markus.on.java.reflect.proxy;

/**
 * @author: markus
 * @date: 2022/8/20 11:00 PM
 * @Description:
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}
