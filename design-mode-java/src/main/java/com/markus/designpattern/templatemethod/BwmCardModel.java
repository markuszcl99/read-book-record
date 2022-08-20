package com.markus.designpattern.templatemethod;

/**
 * @author: markus
 * @date: 2022/7/18 11:32 PM
 * @Description: 宝马车
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class BwmCardModel extends CardModel{

    @Override
    protected void start() {
        System.out.println("宝马车-启动");
    }

    @Override
    protected void engineBoom() {
        System.out.println("宝马车-轰鸣声");
    }

    @Override
    protected void whistle() {
        System.out.println("宝马车-鸣笛");
    }

    @Override
    protected void stop() {
        System.out.println("宝马车-停车");
    }

    @Override
    protected boolean hook() {
        // 宝马车想要体现出轰鸣声
        return true;
    }
}
