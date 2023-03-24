package com.markus.designpattern.chain.scene_one;

/**
 * @author: markus
 * @date: 2023/3/16 10:26 AM
 * @Description: 儿子
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Son extends Handler{
    public Son() {
        super(3);
    }

    @Override
    public void response(String request) {
        System.out.println("Son agree " + request);
    }
}
