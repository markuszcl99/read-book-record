package com.markus.designpattern.factorymethod;/**
* @author: markus
* @date: 2022/7/10 6:01 下午
* @Description: 白种人
* @Blog: http://markuszhang.com/doc-blog/
* It's my honor to share what I've learned with you!
*/
public class WhiteHuman implements Human{
    @Override
    public void laugh() {
        System.out.println("白种人大笑！");
    }
}
