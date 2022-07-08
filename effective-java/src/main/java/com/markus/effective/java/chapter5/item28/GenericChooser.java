package com.markus.effective.java.chapter5.item28;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: markus
 * @date: 2022/5/23 1:17 下午
 * @Description: 使用泛型 数组情况
 * @Blog: http://markuszhang.com/
 */
public class GenericChooser<T> {
    private final T[] choiceArray;

    public GenericChooser(Collection<T> choice){
        // Unchecked cast: 'java.lang.Object[]' to 'T[]'
        choiceArray = (T[]) choice.toArray();
    }

    public Object choose(){
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }

}
