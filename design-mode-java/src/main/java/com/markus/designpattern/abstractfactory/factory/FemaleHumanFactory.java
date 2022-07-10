package com.markus.designpattern.abstractfactory.factory;

import com.markus.designpattern.abstractfactory.product.Human;
import com.markus.designpattern.abstractfactory.product.HumanEnum;

/**
 * @author: markus
 * @date: 2022/7/10 10:33 下午
 * @Description: 女性人类工厂
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class FemaleHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createYellowHuman() {
        return createHuman(HumanEnum.YellowFemaleHuman);
    }

    @Override
    public Human createWhiteHuman() {
        return createHuman(HumanEnum.WhiteFemaleHuman);
    }

    @Override
    public Human createBlackHuman() {
        return createHuman(HumanEnum.BlackFemaleHuman);
    }
}
