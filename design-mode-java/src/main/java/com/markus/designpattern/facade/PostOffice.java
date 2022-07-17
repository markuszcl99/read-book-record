package com.markus.designpattern.facade;

/**
 * @author: markus
 * @date: 2022/7/17 1:31 下午
 * @Description: 邮局-提供模板方法的类
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class PostOffice {
    private LetterProcess letterProcess = new DefaultLetterProcess();

    public PostOffice() {

    }

    public PostOffice(LetterProcess letterProcess) {
        this.letterProcess = letterProcess;
    }

    public void sendLetter(String context, String address) {
        letterProcess.writeContext(context);
        letterProcess.fillEnvelop(address);
        letterProcess.letterInotoEnvelope();
        letterProcess.sendLetter();
    }
}
