package com.markus.designpattern.abstractfactory.product;

/**
 * @author: markus
 * @date: 2022/7/10 10:19 下午
 * @Description: 人类枚举
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public enum HumanEnum {
    YellowFemaleHuman("com.markus.designpattern.abstractfactory.product.YellowFemale"),
    YellowMaleHuman("com.markus.designpattern.abstractfactory.product.YellowMale"),
    WhiteFemaleHuman("com.markus.designpattern.abstractfactory.product.WhiteFemale"),
    WhiteMaleHuman("com.markus.designpattern.abstractfactory.product.WhiteMale"),
    BlackFemaleHuman("com.markus.designpattern.abstractfactory.product.BlackFemale"),
    BlackMaleHuman("com.markus.designpattern.abstractfactory.product.BlackMale");

    private String classPath;

    HumanEnum(String classPath) {
        this.classPath = classPath;
    }

    public String getClassPath(){
        return this.classPath;
    }
}
