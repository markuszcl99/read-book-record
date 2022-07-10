package com.markus.designpattern.abstractfactory.product;

/**
 * @author: markus
 * @date: 2022/7/10 10:09 下午
 * @Description: 黄种人-男人
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class WhiteMale extends WhiteHuman{

    @Override
    public void sex() {
        System.out.println("白种人男性！");
    }
}
