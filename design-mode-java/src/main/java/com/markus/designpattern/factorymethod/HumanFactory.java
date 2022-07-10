package com.markus.designpattern.factorymethod;

import com.markus.designpattern.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: markus
 * @date: 2022/7/10 9:00 下午
 * @Description: 火炉
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class HumanFactory {
    public static Human createHuman(Class clazz) {
        try {
            return (Human) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.err.println("你要求的人类不合法，创造不出！");
        }
        return null;
    }

    public static List<Human> createHuman() {
        List<Human> allHuman = new ArrayList<>();
        // 创建Human的所有实现类
        List<Class> allHumanClass = ClassUtils.getAllClassByInterface(Human.class);
        for (Class humanClass : allHumanClass) {
            allHuman.add(createHuman(humanClass));
        }
        return allHuman;
    }
}
