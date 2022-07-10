package com.markus.designpattern.abstractfactory.factory;

import com.markus.designpattern.abstractfactory.product.Human;
import com.markus.designpattern.abstractfactory.product.YellowHuman;

/**
 * @author: markus
 * @date: 2022/7/10 10:15 下午
 * @Description: 火炉-工厂接口
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface HumanFactory {

    Human createYellowHuman();

    Human createWhiteHuman();

    Human createBlackHuman();
}
