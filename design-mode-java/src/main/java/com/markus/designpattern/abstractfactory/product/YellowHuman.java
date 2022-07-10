package com.markus.designpattern.abstractfactory.product;

/**
 * @author: markus
 * @date: 2022/7/10 10:06 下午
 * @Description: 黄种人抽象类
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public abstract class YellowHuman implements Human {
    @Override
    public void laugh() {
        System.out.println("黄种人大笑！");
    }
}
