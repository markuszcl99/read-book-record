package com.markus.designpattern.strategy;

/**
 * @author: markus
 * @date: 2022/7/8 10:36 下午
 * @Description: 偷看同学试卷
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class Peep implements IStrategy{
    @Override
    public void operate() {
        System.out.println("偷看同学试卷！");
    }
}
