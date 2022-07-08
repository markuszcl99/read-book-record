package com.markus.effective.java.chapter5.item26;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: markus
 * @date: 2022/5/22 11:36 下午
 * @Description: 原生的
 * @Blog: http://markuszhang.com/
 */
public class Raw {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String str = strings.get(0);
    }

    // don't do this
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
