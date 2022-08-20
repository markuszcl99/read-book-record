package com.markus.on.java.reflect;

import java.util.Random;

/**
 * @author: markus
 * @date: 2022/8/20 12:03 PM
 * @Description: 类字面量演示，关于static、final字段提前初始化等现象
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
class Initable {
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL2 = ClassLiteralDemo.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int STATIC_NON_FINAL = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int STATIC_NON_FINAL = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassLiteralDemo {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        // 使用一个类之前需要经过三个步骤：类加载、链接、初始化
        // 类加载：通过类加载器找到字节码(通常从磁盘中，但也不一定)，然后通过这些字节码创建一个class对象
        // 链接：此阶段会验证类中的字节码(保证安全)，为静态字段分配存储空间，并在必要时解析该类对其他类的所有引用
        // 初始化：如果有基类，会先初始化基类，执行静态初始化器和静态初始化块
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        // 如果static final字段是编译时常量，则通过类调用的话不会触发类的初始化
        System.out.println(Initable.STATIC_FINAL);
        // 如果static final字段不是编译时常量，则通过类调用的话会触发初始化
        System.out.println(Initable.STATIC_FINAL2);
        // 如果static字段不是final的，那么如果想要读取这个字段的话，总是需要经过链接(为静态字段分配存储)和初始化(初始化该存储)
        System.out.println(Initable2.STATIC_NON_FINAL);
        // Class.forName()总是会初始化类来生成类的引用
        Class initable3 = Class.forName("com.markus.on.java.reflect.Initable3");
        System.out.println("After creating initable3 ref");
        System.out.println(Initable3.STATIC_NON_FINAL);
    }
}
