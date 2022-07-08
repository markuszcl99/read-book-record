package com.markus.effective.java.chapter5.item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: markus
 * @date: 2022/5/23 1:13 下午
 * @Description: 普通方法
 * @Blog: http://markuszhang.com/
 */
public class Chooser {
    private final Object[] choiceArray;

    public Chooser(Collection choices){
        choiceArray = choices.toArray();
    }

    /**
     * 使用此方法，客户端每次都需要进行类型转换，如果转换错误，会发生运行时错误
     * @return
     */
    public Object choose(){
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
