package com.markus.designpattern.templatemethod;

/**
 * @author: markus
 * @date: 2022/7/18 11:29 PM
 * @Description: 车模型-抽象类
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public abstract class CardModel {
    public void run() {
        // 启动
        this.start();
        if (hook()) {
            // 默认不开启轰鸣声
            // 引擎轰鸣声
            this.engineBoom();
        }
        // 鸣笛
        this.whistle();
        // 停车
        this.stop();
    }

    protected boolean hook() {
        return false;
    }

    protected abstract void start();

    protected abstract void engineBoom();

    protected abstract void whistle();

    protected abstract void stop();
}
