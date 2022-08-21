package com.markus.on.java.reflect.check;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: markus
 * @date: 2022/8/20 6:18 PM
 * @Description:
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class ForNamePetCreator extends Creator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
            "com.markus.on.java.reflect.check.Dog",
            "com.markus.on.java.reflect.check.Cat"
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String typeName : typeNames) {
                types.add(
                        (Class<? extends Pet>) Class.forName(typeName)
                );
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
