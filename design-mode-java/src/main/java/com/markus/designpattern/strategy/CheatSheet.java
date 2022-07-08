package com.markus.designpattern.strategy;

/**
 * @author: markus
 * @date: 2022/7/8 10:31 下午
 * @Description: 打小抄
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class CheatSheet implements IStrategy {
    @Override
    public void operate() {
        System.out.println("打小抄");
    }
}
