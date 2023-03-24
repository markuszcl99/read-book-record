package com.markus.designpattern.chain.scene_one;

/**
 * @author: markus
 * @date: 2023/3/16 10:24 AM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Father extends Handler {
    public Father() {
        super(1);
    }

    @Override
    public void response(String request) {
        System.out.println("Father agree " + request);
    }
}
