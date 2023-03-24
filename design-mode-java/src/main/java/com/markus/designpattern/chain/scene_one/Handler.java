package com.markus.designpattern.chain.scene_one;

/**
 * @author: markus
 * @date: 2023/3/16 10:17 AM
 * @Description: 责任链处理器
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public abstract class Handler {
    private int currentProcessType;
    private Handler nextHandler;

    public Handler(int type) {
        this.currentProcessType = type;
    }

    public void handleMessage(IWoman women) {
        // 应该是当前节点处理
        if (women.getType() == currentProcessType) {
            response(women.getRequest());
        } else {
            if (nextHandler != null) {
                nextHandler.handleMessage(women);
            } else {
                // ... 不处理
            }
        }
    }

    public void selectNext(Handler handler) {
        this.nextHandler = handler;
    }

    public abstract void response(String request);
}
