package com.markus.designpattern.abstractfactory.client;

import com.markus.designpattern.abstractfactory.factory.FemaleHumanFactory;
import com.markus.designpattern.abstractfactory.factory.MaleHumanFactory;
import com.markus.designpattern.abstractfactory.product.Human;

/**
 * @author: markus
 * @date: 2022/7/10 10:35 下午
 * @Description: 女娲-客户端
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class Nvwa {
    public static void main(String[] args) {
        // 男性工厂
        MaleHumanFactory maleHumanFactory = new MaleHumanFactory();
        // 女性工厂
        FemaleHumanFactory femaleHumanFactory = new FemaleHumanFactory();

        Human maleYellowHuman = maleHumanFactory.createYellowHuman();
        maleYellowHuman.sex();

        Human maleWhiteHuman = maleHumanFactory.createWhiteHuman();
        maleWhiteHuman.sex();

        Human maleBlackHuman = maleHumanFactory.createBlackHuman();
        maleBlackHuman.sex();

        Human femaleYellowHuman = femaleHumanFactory.createYellowHuman();
        femaleYellowHuman.sex();

        Human femaleWhiteHuman = femaleHumanFactory.createWhiteHuman();
        femaleWhiteHuman.sex();

        Human femaleBlackHuman = femaleHumanFactory.createBlackHuman();
        femaleBlackHuman.sex();
    }
}
