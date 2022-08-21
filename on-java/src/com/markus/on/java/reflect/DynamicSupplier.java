package com.markus.on.java.reflect;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author: markus
 * @date: 2022/8/20 4:45 PM
 * @Description: 动态引用提供者
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
class ID {
    private static long counter;

    private final long id = counter++;

    public ID() {
    }

    @Override
    public String toString() {
        return Long.toString(id);
    }
}

public class DynamicSupplier<T> implements Supplier<T> {

    private Class<T> type;

    public DynamicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            return type.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Stream.generate(new DynamicSupplier<>(ID.class)) // generate 通过Supplier对象生成流
                .skip(10) // skip 跳过前n个元素
                .limit(5) // limit 截断5个
                .forEach(System.out::println); // 打印
    }
}
