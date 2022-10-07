package com.markus.java.jvm.bytecode;

import org.junit.Test;

/**
 * @author: markus
 * @date: 2022/9/25 10:40 PM
 * @Description: 字节码面试
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class InterviewTest {
    @Test
    public void test1(){
        Integer x = 128;
        int y = 128;
        System.out.println(x == y);//true 自动拆箱
    }
}
