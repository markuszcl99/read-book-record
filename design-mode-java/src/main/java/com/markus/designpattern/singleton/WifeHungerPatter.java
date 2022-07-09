package com.markus.designpattern.singleton;

import java.io.Serializable;

/**
 * @author: markus
 * @date: 2022/7/9 12:27 下午
 * @Description: 妻子-饿汉模式，根据static类加载的时候只被加载一遍的特性，直接实例化一个静态对象，保证线程安全，全局只会有一个实例
 * 这样最省事，但会有一个弊端，如果对象很大，会一直占用内存不释放，如果不使用或使用次数很少，会对内存造成浪费
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class WifeHungerPatter implements Serializable {
    private static WifeHungerPatter instance = new WifeHungerPatter();

    private WifeHungerPatter() {
    }

    public static WifeHungerPatter getInstance() {
        return instance;
    }

    // 编写此方法，返回唯一的实例，这样在反序列化过程中就会返回此唯一的实例
    public Object readResolve() {
        return instance;
    }
}
