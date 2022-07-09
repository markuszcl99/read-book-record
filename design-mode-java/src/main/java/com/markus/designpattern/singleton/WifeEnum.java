package com.markus.designpattern.singleton;

/**
 * @author: markus
 * @date: 2022/7/9 12:54 下午
 * @Description: 妻子-枚举形式实现单例模式
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public enum WifeEnum {
    INSTANCE;

    public WifeEnum getInstance() {
        return INSTANCE;
    }
}
