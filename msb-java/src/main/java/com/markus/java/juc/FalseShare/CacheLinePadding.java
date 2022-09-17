package com.markus.java.juc.FalseShare;

/**
 * @author: markus
 * @date: 2022/9/17 11:58 PM
 * @Description: 伪共享
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class CacheLinePadding {
    private static class T {
        public volatile long x = 0L;
    }

    // 大概率会被CPU加载到同一个缓存行中
    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread r1 = new Thread(() -> {
            for (long i = 0; i < 100_0000L; i++)
                arr[0].x = i;
        });

        Thread r2 = new Thread(() -> {
            for (long i = 0; i < 100_0000L; i++)
                arr[1].x = i;
        });

        final long startTime = System.nanoTime();
        r1.start();
        r2.start();
        r1.join();
        r2.join();
        System.out.println(System.nanoTime() - startTime);

    }
}
