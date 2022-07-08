package com.markus.designpattern.strategy;

/**
 * @author: markus
 * @date: 2022/7/8 10:34 下午
 * @Description: 考前复习
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class Review implements IStrategy{
    @Override
    public void operate() {
        System.out.println("考前好好复习，考试不挂科！");
    }
}
