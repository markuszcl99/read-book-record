package com.markus.java.juc.cpu.wc;

/**
 * @author: markus
 * @date: 2022/9/18 4:17 PM
 * @Description: 合并写
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class WriteCombine_byte {
    private static final int ITERATIONS = Integer.MAX_VALUE;
    private static final int ITEMS = 1 << 24;
    private static final int MASK = ITEMS - 1;

    private static byte arrayA[];
    private static byte arrayB[];
    private static byte arrayC[];
    private static byte arrayD[];
    private static byte arrayE[];
    private static byte arrayF[];
    private static byte arrayG[];
    private static byte arrayH[];

    static {
        arrayA = new byte[ITEMS];
        arrayB = new byte[ITEMS];
        arrayC = new byte[ITEMS];
        arrayD = new byte[ITEMS];
        arrayE = new byte[ITEMS];
        arrayF = new byte[ITEMS];
        arrayG = new byte[ITEMS];
        arrayH = new byte[ITEMS];
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            System.out.println(i + " SingleLoop duration (ms) = " + runCaseOne() / 100_0000);
            System.out.println(i + " SplitLoop duration (ms) = " + runCaseTwo() / 100_0000);
        }
//        System.out.println(ITEMS);
//        System.out.println((int) Math.pow(2, 24));
    }

    private static double runCaseOne() {
        long start = System.nanoTime();
        int i = ITERATIONS;
        while (--i != 0) {
            int slot = i & MASK;
            byte b = (byte) i;
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
            byte b = (byte) i;
            arrayA[slot] = b;
            arrayB[slot] = b;
            arrayC[slot] = b;
            arrayD[slot] = b;
        }
        i = ITERATIONS;
        while (--i != 0) {
            int slot = i & MASK;
            byte b = (byte) i;
            arrayE[slot] = b;
            arrayF[slot] = b;
            arrayG[slot] = b;
            arrayH[slot] = b;
        }
        return System.nanoTime() - start;
    }
}
