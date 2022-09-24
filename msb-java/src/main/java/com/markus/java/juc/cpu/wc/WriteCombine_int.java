package com.markus.java.juc.cpu.wc;

/**
 * @author: markus
 * @date: 2022/9/18 4:17 PM
 * @Description: 合并写
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class WriteCombine_int {
    private static final int ITERATIONS = Integer.MAX_VALUE;
    private static final int ITEMS = 1 << 24;
    private static final int MASK = ITEMS - 1;

    private static int arrayA[];
    private static int arrayB[];
    private static int arrayC[];
    private static int arrayD[];
    private static int arrayE[];
    private static int arrayF[];
    private static int arrayG[];
    private static int arrayH[];

    static {
        arrayA = new int[ITEMS];
        arrayB = new int[ITEMS];
        arrayC = new int[ITEMS];
        arrayD = new int[ITEMS];
        arrayE = new int[ITEMS];
        arrayF = new int[ITEMS];
        arrayG = new int[ITEMS];
        arrayH = new int[ITEMS];
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            System.out.println(i + " SingleLoop duration (ms) = " + runCaseOne() / 100_0000);
            System.out.println(i + " SplitLoop duration (ms) = " + runCaseTwo() / 100_0000);
        }
    }

    private static double runCaseOne() {
        long start = System.nanoTime();
        int i = ITERATIONS;
        while (--i != 0) {
            int slot = i & MASK;
            int b = i;
            // 以下不在同一个缓存行中
            // 相当于载入8个缓存行
            // 而现代CPU基本上 单核可以同时获取4个缓存行存储合并缓冲区中
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
            int b = i;
            arrayA[slot] = b;
            arrayB[slot] = b;
            arrayC[slot] = b;
            arrayD[slot] = b;
        }
        i = ITERATIONS;
        while (--i != 0) {
            int slot = i & MASK;
            int b = i;
            arrayE[slot] = b;
            arrayF[slot] = b;
            arrayG[slot] = b;
            arrayH[slot] = b;
        }
        return System.nanoTime() - start;
    }
}
