package com.markus.designpattern.proxy;

/**
 * @author: markus
 * @date: 2022/7/9 11:48 上午
 * @Description: 代理-双簧的出面人
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class FrontMan implements Duet {
    private BackMan backMan;

    public FrontMan() {
        this.backMan = new BackMan();//双簧演奏，出面人做为实际讲话人的代理
    }

    @Override
    public void say() {
        backMan.say();
    }
}
