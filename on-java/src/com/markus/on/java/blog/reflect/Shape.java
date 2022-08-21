package com.markus.on.java.blog.reflect;

/**
 * @author: markus
 * @date: 2022/8/21 9:51 PM
 * @Description: 用来描述形状的接口
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public abstract class Shape {
    public void draw() {
        System.out.println(this + ".draw()");
    }

    @Override
    public abstract String toString();
}
