package com.markus.designpattern.factorymethod;

/**
 * @author: markus
 * @date: 2022/7/10 5:59 下午
 * @Description: 黑人
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class BlackHuman implements Human{
    @Override
    public void laugh() {
        System.out.println("黑人大笑！");
    }
}
