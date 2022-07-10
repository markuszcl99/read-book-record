package com.markus.designpattern.abstractfactory.product;

/**
 * @author: markus
 * @date: 2022/7/10 10:09 下午
 * @Description: 黑人男性
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class BlackMale extends BlackHuman{

    @Override
    public void sex() {
        System.out.println("黑人男性！");
    }
}
