package com.markus.designpattern.templatemethod;

/**
 * @author: markus
 * @date: 2022/7/18 11:32 PM
 * @Description: 奥迪
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class AudiCardModel extends CardModel{

    @Override
    protected void start() {
        System.out.println("奥迪-启动");
    }

    @Override
    protected void engineBoom() {
        System.out.println("奥迪-轰鸣声");
    }

    @Override
    protected void whistle() {
        System.out.println("奥迪-鸣笛");
    }

    @Override
    protected void stop() {
        System.out.println("奥迪-停车");
    }
}
