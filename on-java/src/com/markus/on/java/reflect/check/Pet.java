package com.markus.on.java.reflect.check;

/**
 * @author: markus
 * @date: 2022/8/20 5:59 PM
 * @Description: 宠物
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class Pet {
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public Pet() {

    }

    @Override
    public String toString() {
        return this.name;
    }
}
