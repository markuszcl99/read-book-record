package com.markus.designpattern.singleton;

/**
 * @author: markus
 * @date: 2022/7/9 12:35 下午
 * @Description: 妻子-双重检验锁模式，代码实现线程安全
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class WifeDoubleCheckoutLockPattern {
    private static WifeDoubleCheckoutLockPattern instance;

    private WifeDoubleCheckoutLockPattern(){}

    public static WifeDoubleCheckoutLockPattern getInstance(){
        // 第一重校验
        if (instance == null){
            synchronized (WifeDoubleCheckoutLockPattern.class){
                // 拿到锁 再校验一遍，这次校验保证是线程安全的
                if (instance == null){
                    instance = new WifeDoubleCheckoutLockPattern();
                }
            }
        }
        return instance;
    }
}
