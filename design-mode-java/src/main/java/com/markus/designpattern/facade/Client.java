package com.markus.designpattern.facade;

/**
 * @author: markus
 * @date: 2022/7/17 1:40 下午
 * @Description: 写信者
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class Client {
    public static void main(String[] args) {
        PostOffice postOffice = new PostOffice();
        postOffice.sendLetter("实践是最好的领悟方式","未来局");
    }
}
