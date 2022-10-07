package com.markus.java.jvm.classload;

/**
 * @author: markus
 * @date: 2022/10/6 4:35 PM
 * @Description: 被动使用类字段
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println("------------------------演示一------------------------");
        // 一、引用父类的常量字段，子类不会触发类型的初始化
        int value = SonClass.value;
        System.out.println("------------------------演示二------------------------");
        // 二、创建对象数组，该对象不会触发该类型的初始化
        ObjectArrayClass[] arrayClasses = new ObjectArrayClass[10];
        System.out.println("------------------------演示三------------------------");
        // 三、常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
        int value2 = ConstClass.value;

    }
}

class FatherClass {
    static {
        System.out.println("FatherClass init");
    }

    public static int value = 123;
}

class SonClass extends FatherClass {
    static {
        System.out.println("SonClass init");
    }
}

class ObjectArrayClass {
    static {
        System.out.println("ObjectArrayClass init");
    }
}

class ConstClass {
    static {
        System.out.println("ConstClass init");
    }

    public static final int value = 123;
}
