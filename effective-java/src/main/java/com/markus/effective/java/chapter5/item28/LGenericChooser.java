package com.markus.effective.java.chapter5.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: markus
 * @date: 2022/5/23 1:22 下午
 * @Description: 使用泛型 列表情况
 * @Blog: http://markuszhang.com/
 */
public class LGenericChooser<T> {
    private final List<T> choiceList;

    public LGenericChooser(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {

    }
}
