package com.markus.designpattern.strategy;

/**
 * @author: markus
 * @date: 2022/7/8 10:38 δΈε
 * @Description: θθ―
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class Exam {
    private IStrategy iStrategy;

    public Exam(IStrategy iStrategy){
        this.iStrategy = iStrategy;
    }

    public void exam(){
        iStrategy.operate();
    }
}
