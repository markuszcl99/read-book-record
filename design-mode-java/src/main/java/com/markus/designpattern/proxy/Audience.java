package com.markus.designpattern.proxy;

/**
 * @author: markus
 * @date: 2022/7/9 11:52 上午
 * @Description: 观众-观看双簧节目
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class Audience {
    public static void main(String[] args) {
        FrontMan duet = new FrontMan();//观众看到双簧节目的出面人
        duet.say();// 观众看着像是出面人在讲话，实际上是背后的人在讲话
    }
}
