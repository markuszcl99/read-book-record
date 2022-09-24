package com.markus.java.juc.cpu.wc;

/**
 * @author: markus
 * @date: 2022/9/18 4:17 PM
 * @Description: 合并写
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class WriteCombine_long {
    private static final int ITERATIONS = Integer.MAX_VALUE;
    private static final int ITEMS = 1 << 24;
    private static final int MASK = ITEMS - 1;

    private static long arrayA[];
    private static long arrayB[];
    private static long arrayC[];
    private static long arrayD[];
    private static long arrayE[];
    private static long arrayF[];
    private static long arrayG[];
    private static long arrayH[];

    static {
        arrayA = new long[ITEMS];
        arrayB = new long[ITEMS];
        arrayC = new long[ITEMS];
        arrayD = new long[ITEMS];
        arrayE = new long[ITEMS];
        arrayF = new long[ITEMS];
        arrayG = new long[ITEMS];
        arrayH = new long[ITEMS];
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            System.out.println(i + " SingleLoop duration (ms) = " + runCaseOne() / 100_0000);
            System.out.println(i + " SplitLoop duration (ms) = " + runCaseTwo() / 100_0000);
        }
    }

    // 数组包括2^24个long类型数据，有8个数组，占
    private static double runCaseOne() {
        long start = System.nanoTime();
        int i = ITERATIONS;
        while (--i != 0) {
            int slot = i & MASK;
            long b = i;
            // 以下不在同一个缓存行中
            // 相当于载入8个缓存行
            // 而现代CPU基本上 单核可以同时获取4个缓存行存储到合并缓冲区中
            arrayA[slot] = b;
            arrayB[slot] = b;
            arrayC[slot] = b;
            arrayD[slot] = b;
            arrayE[slot] = b;
            arrayF[slot] = b;
            arrayG[slot] = b;
            arrayH[slot] = b;
        }
        return System.nanoTime() - start;
    }

    private static double runCaseTwo() {
        long start = System.nanoTime();
        int i = ITERATIONS;
        while (--i != 0) {
            int slot = i & MASK;
            long b = i;
            // 而现代CPU基本上 单核可以同时获取4个缓存行存储到合并缓冲区中
            arrayA[slot] = b;
            arrayB[slot] = b;
            arrayC[slot] = b;
            arrayD[slot] = b;
        }
        i = ITERATIONS;
        while (--i != 0) {
            int slot = i & MASK;
            long b = i;
            // 而现代CPU基本上 单核可以同时获取4个缓存行存储到合并缓冲区中
            arrayE[slot] = b;
            arrayF[slot] = b;
            arrayG[slot] = b;
            arrayH[slot] = b;
        }
        return System.nanoTime() - start;
    }
}
