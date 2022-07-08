package com.markus.effective.java.chapter5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: markus
 * @date: 2022/5/22 11:02 下午
 * @Description: 第五章演示示例
 * @Blog: http://markuszhang.com/
 */
public class ChapterFiveDemo {
    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        testAdd(list, integerList);
    }

    public static void testAdd(List<Number> list, List<Integer> integerList) {
        list.addAll(integerList);
    }
}
