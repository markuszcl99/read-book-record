package com.markus.designpattern.abstractfactory.factory;

import com.markus.designpattern.abstractfactory.product.Human;
import com.markus.designpattern.abstractfactory.product.HumanEnum;

/**
 * @author: markus
 * @date: 2022/7/10 10:18 下午
 * @Description: 抽象工厂
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public abstract class AbstractHumanFactory implements HumanFactory {
    protected Human createHuman(HumanEnum humanEnum) {
        if (!humanEnum.getClassPath().equals("")) {
            try {
                return (Human) Class.forName(humanEnum.getClassPath()).newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
