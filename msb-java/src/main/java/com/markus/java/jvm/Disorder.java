package com.markus.java.jvm;

/**
 * @author: markus
 * @date: 2022/9/18 10:14 PM
 * @Description: 指令乱序执行证明
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Disorder {

    private static volatile int a = 0, b = 0;
    private static int x = 0, y = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
            });


            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            if (x == 0 && y == 0)
                break;
        }
        System.out.println("第" + i + "次执行，(x,y)结果为:(" + x + "," + y + ")");
    }
}
