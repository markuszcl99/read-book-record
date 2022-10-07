package com.markus.java.jvm.classload;

/**
 * @author: markus
 * @date: 2022/10/4 5:55 PM
 * @Description: 类加载时机的一种场景
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface JDK8Interface {

    Person person = new Person();

    static void staticMethod(){
        System.out.println("接口的静态方法");
    }

    default void defaultMethod() {
        Person person = new Person();
    }
}
