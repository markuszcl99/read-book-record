package com.markus.on.java.reflect;

/**
 * @author: markus
 * @date: 2022/8/20 11:52 AM
 * @Description: Class.forName()演示
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
// 电池
interface HasBatteries {
}

// 防水的
interface Waterproof {
}

interface Shoots {
}

class Tony {
    public Tony() {

    }

    public Tony(int i) {

    }
}

class FancyToy extends Tony implements HasBatteries, Waterproof, Shoots {
    public FancyToy() {
        super(1);
    }
}

public class ClassForNameDemo {
    static void printInfo(Class clazz) {
        System.out.println("Class name: " + clazz.getName() + " is interface? [" + clazz.isInterface() + "]");
        System.out.println("Simple name: " + clazz.getSimpleName());
        System.out.println("Canonical name: " + clazz.getCanonicalName());
    }

    public static void main(String[] args) {
        Class clazz = null;
        try {
            clazz = Class.forName("com.markus.on.java.reflect.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(clazz);
        for (Class clazzInterface : clazz.getInterfaces()) {
            printInfo(clazzInterface);
        }
        Class up = clazz.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Cannot instantiate");
        }
        printInfo(obj.getClass());
    }
}
