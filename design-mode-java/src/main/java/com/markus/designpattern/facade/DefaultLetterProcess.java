package com.markus.designpattern.facade;

/**
 * @author: markus
 * @date: 2022/7/17 1:35 下午
 * @Description: 默认的写信流程内容
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class DefaultLetterProcess implements LetterProcess {
    @Override
    public void writeContext(String context) {
        System.out.println("写信内容为：" + context);
    }

    @Override
    public void fillEnvelop(String address) {
        System.out.println("信封地址为：" + address);
    }

    @Override
    public void letterInotoEnvelope() {
        System.out.println("将信纸放进信封中");
    }

    @Override
    public void sendLetter() {
        System.out.println("投递信封");
    }
}
