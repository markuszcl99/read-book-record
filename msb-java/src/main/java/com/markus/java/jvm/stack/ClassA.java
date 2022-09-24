package com.markus.java.jvm.stack;

/**
 * @author: markus
 * @date: 2022/9/20 11:26 PM
 * @Description: 指令学习
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ClassA {
    public static void main(String[] args) {
        ClassA classA = new ClassA();
        classA.declare();
    }

    public void declare() {
        int i = 100;
        int j = 200;
        int k = 1 << 15;
        int m = 1 << 32 - 1;
        long n = 1L << 64 - 1;
    }

    public void add(int a, int b) {
        int i = a + b;
    }
}
