package com.markus.designpattern.chain.scene_one;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: markus
 * @date: 2023/3/16 10:28 AM
 * @Description: 客户端
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Client {
    public static void main(String[] args) {
        Random random = new Random();
        List<IWoman> women = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            IWoman woman = new Women(random.nextInt(3) + 1, "出门逛街");
            women.add(woman);
        }
        Father father = new Father();
        Husband husband = new Husband();
        Son son = new Son();

        father.selectNext(husband);
        husband.selectNext(son);

        for (IWoman woman : women) {
            System.out.println("----------start---------");
            father.handleMessage(woman);
            System.out.println("----------end---------");
        }
    }
}
