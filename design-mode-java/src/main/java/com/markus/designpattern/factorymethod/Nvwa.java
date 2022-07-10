package com.markus.designpattern.factorymethod;

import java.util.List;

/**
 * @author: markus
 * @date: 2022/7/10 9:04 下午
 * @Description: 女娲
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class Nvwa {
    public static void main(String[] args) {
        Human yellowHuman = HumanFactory.createHuman(YellowHuman.class);
        yellowHuman.laugh();

        Human whiteHuman = HumanFactory.createHuman(WhiteHuman.class);
        whiteHuman.laugh();

        Human blackHuman = HumanFactory.createHuman(BlackHuman.class);
        blackHuman.laugh();


        List<Human> allHuman = HumanFactory.createHuman();
        for (Human human : allHuman) {
            human.laugh();
        }
    }
}
