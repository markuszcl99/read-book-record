package com.markus.java.jvm.classload;

/**
 * @author: markus
 * @date: 2022/10/4 6:03 PM
 * @Description: Person类
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Person {

    static {
        System.out.println("Person被加载了");
    }

    static void method(){
        System.out.println("Person类的静态方法被调用了");
    }

    public Person(){
        System.out.println("Person被初始化了");
    }
}
