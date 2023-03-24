package com.markus.designpattern.chain.scene_one;

/**
 * @author: markus
 * @date: 2023/3/16 10:27 AM
 * @Description: 丈夫
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Husband extends Handler {
    public Husband() {
        super(2);
    }

    @Override
    public void response(String request) {
        System.out.println("Husband agree " + request);
    }
}
