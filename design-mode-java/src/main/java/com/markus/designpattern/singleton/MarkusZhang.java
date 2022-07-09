package com.markus.designpattern.singleton;

import java.io.*;

/**
 * @author: markus
 * @date: 2022/7/9 12:28 下午
 * @Description: 我
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class MarkusZhang {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        WifeHungerPatter wife = WifeHungerPatter.getInstance();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("WifeHungerPatter.txt"));
        out.writeObject(wife);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("WifeHungerPatter.txt"));
        Object obj = in.readObject();

        WifeHungerPatter wifeHungerPatter = (WifeHungerPatter) obj;

        System.out.println(wife == wifeHungerPatter);

    }
}
