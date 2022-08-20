package com.markus.designpattern.templatemethod;

/**
 * @author: markus
 * @date: 2022/7/18 11:35 PM
 * @Description: 客户端-用户看车
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class Client {
    public static void main(String[] args) {
        CardModel bwm = new BwmCardModel();
        bwm.run();

        CardModel audi = new AudiCardModel();
        audi.run();
    }
}
