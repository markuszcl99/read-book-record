package com.markus.on.java.reflect.check;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: markus
 * @date: 2022/8/20 5:58 PM
 * @Description: 创建器
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public abstract class Creator implements Supplier<Pet> {
    private Random rand = new Random(47);

    public abstract List<Class<? extends Pet>> types();

    @Override
    public Pet get() {
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).getConstructor().newInstance();
        } catch (InstantiationException |
                 IllegalAccessException |
                 InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public Stream<Pet> stream() {
        return Stream.generate(this);
    }

    public Pet[] array(int size) {
        return stream().limit(size).toArray(Pet[]::new);
    }

    public List<Pet> list(int size) {
        return stream().limit(size).collect(Collectors.toList());
    }
}
