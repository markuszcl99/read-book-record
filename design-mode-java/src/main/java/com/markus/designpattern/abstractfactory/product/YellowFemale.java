package com.markus.designpattern.abstractfactory.product;

/**
 * @author: markus
 * @date: 2022/7/10 10:09 下午
 * @Description: 黄种人-男人
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class YellowFemale extends YellowHuman{

    @Override
    public void sex() {
        System.out.println("黄种人女性！");
    }
}
