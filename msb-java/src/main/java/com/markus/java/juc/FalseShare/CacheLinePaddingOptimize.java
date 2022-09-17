package com.markus.java.juc.FalseShare;

/**
 * @author: markus
 * @date: 2022/9/18 12:05 AM
 * @Description: 利用缓存行优化程序运行效率
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class CacheLinePaddingOptimize {
    private static class T {
        private long l1, l2, l3, l4, l5, l6, l7;
        public volatile long x = 0l;
        private long r1, r2, r3, r4, r5, r6, r7;
    }

    // 利用缓存行对齐，则arr数组的两个T对象一定不在同一个缓存行中
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
