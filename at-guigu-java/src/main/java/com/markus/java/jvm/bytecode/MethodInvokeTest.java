package com.markus.java.jvm.bytecode;

import java.util.Comparator;

/**
 * @author: markus
 * @date: 2022/9/25 10:37 PM
 * @Description: 方法调用的字节码demo
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class MethodInvokeTest {
    public static void main(String[] args) {
        Father1 f = new Father1();
        Son1 s = new Son1();
        System.out.println(f.getInfo());
        System.out.println(s.getInfo());

        Son1.show();

        Comparator<Integer> comparator = Integer::compareTo;

        comparator.compare(12,32);
    }
}

class Father1 {
    private String info = "atguigu";

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}

class Son1 extends Father1 {
    private String info = "尚硅谷";

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public static void show(){
        System.out.println("hello");
    }

}
