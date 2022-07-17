package com.markus.designpattern.facade;

/**
 * @author: markus
 * @date: 2022/7/17 11:01 上午
 * @Description: 写信处理
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface LetterProcess {
    /**
     * 写信的内容
     *
     * @param context
     */
    void writeContext(String context);

    /**
     * 写信封
     *
     * @param address
     */
    void fillEnvelop(String address);

    /**
     * 将信放在信封里
     */
    void letterIntoEnvelope();

    /**
     * 将信邮递
     */
    void sendLetter();
}
