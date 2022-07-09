package com.markus.designpattern.proxy;

/**
 * @author: markus
 * @date: 2022/7/9 11:49 上午
 * @Description: 双簧-实际说话的人
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class BackMan implements Duet{
    @Override
    public void say() {
        System.out.println("出面人是大笨驴 哈哈哈(我才是实际说话的人)");
    }
}
