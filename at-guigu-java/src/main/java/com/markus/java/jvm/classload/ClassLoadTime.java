package com.markus.java.jvm.classload;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: markus
 * @date: 2022/10/4 4:09 PM
 * @Description: 类加载时机
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ClassLoadTime implements JDK8Interface {
    static {
        System.out.println("ClassLoadTime类加载");
    }

    public static void main(String[] args) {
        ClassLoadTime demo = new ClassLoadTime();
//        demo.testNew();
//        demo.testStaticField();
//        demo.testStaticMethod();
//        demo.testReflectMethodInvoke();
//        demo.testLoadFatherClass();
        demo.testMethodHandle();
    }

    /**
     * 该方法的字节码指令内容
     * 0 new #5 <com/markus/java/jvm/classload/A>
     * 3 dup
     * 4 invokespecial #6 <com/markus/java/jvm/classload/A.<init> : ()V>
     * 7 astore_1
     * 8 return
     */
    public void testNew() {
        //1. 使用new关键字实例化对象的时候
        A a = new A();
    }

    /**
     * 该方法的字节码指令内容
     * 0 getstatic #7 <com/markus/java/jvm/classload/A.id : I>
     * 3 istore_1
     * 4 return
     */
    public void testReadStaticField() {
        //2.1 获取一个静态字段的时候
        int id = A.id;
    }

    /**
     * 该方法的字节码指令内容
     * 0 iconst_2
     * 1 putstatic #7 <com/markus/java/jvm/classload/A.id : I>
     * 4 return
     */
    public void testSetStaticField() {
        //2.2 设置一个静态字段的时候
        A.id = 2;
    }


    /**
     * 该方法的字节码指令内容
     * 0 invokestatic #8 <com/markus/java/jvm/classload/A.method : ()V>
     * 3 return
     */
    public void testStaticMethod() {
        //3. 调用一个类型的静态方法的时候
        A.method();
    }

    public void testReflectMethodInvoke() {
        // 使用java.lang.reflect包的方法对类型进行反射调用的时候，如果类型没有进行过初始化，则需要先触发其初始化
        try {
            Class<?> clazz = Class.forName("com.markus.java.jvm.classload.A");
            A a = (A) clazz.newInstance();
//            A a1 = (A) clazz.newInstance();// 每个类型只被加载一遍
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.err.println("反射处理异常!");
        }
    }

    public void testLoadFatherClass() {
        // 当初始化类的时候，如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化
        ASon son = new ASon();
    }

    public void testMethodHandle() {
        MethodHandle mh = getAStaticMethodMH();
        try {
            // REF_invokeStatic
            mh.invoke();
        } catch (Throwable e) {
            System.err.println("方法句柄调用失败");
        }
    }

    /**
     * 获取方法句柄
     *
     * @return
     */
    public static MethodHandle getAStaticMethodMH() {
        //获取方法类型 参数为:1.返回值类型,2方法中参数类型
        MethodType mt = MethodType.methodType(void.class);
        MethodHandle mh = null;
        try {
            //查找方法句柄
            mh = MethodHandles.lookup().findStatic(A.class, "method", mt);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return mh;
    }
}

class A {
    static int id;

    static {
        System.out.println("A类静态代码块");
    }

    public static void method() {
        System.out.println("A类静态方法");
    }

    public A() {
        System.out.println("A类构造器");
    }
}

class ASon extends A {
    public ASon() {
        System.out.println("ASon类构造器");
    }
}
