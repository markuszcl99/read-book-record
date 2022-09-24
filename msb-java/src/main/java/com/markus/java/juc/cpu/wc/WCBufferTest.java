package com.markus.java.juc.cpu.wc;

/**
 * @author: markus
 * @date: 2022/9/18 2:36 PM
 * @Description: 合并写缓冲区测试
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class WCBufferTest {
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
    private static int arrayI[];
    private static int arrayJ[];
    private static int arrayK[];
    private static int arrayL[];

    static {
        arrayA = new int[ITEMS];
        arrayB = new int[ITEMS];
        arrayC = new int[ITEMS];
        arrayD = new int[ITEMS];
        arrayE = new int[ITEMS];
        arrayF = new int[ITEMS];
        arrayG = new int[ITEMS];
        arrayH = new int[ITEMS];
        arrayI = new int[ITEMS];
        arrayJ = new int[ITEMS];
        arrayK = new int[ITEMS];
        arrayL = new int[ITEMS];
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
            // 4 byte * 12 = 48 byte
            arrayA[slot] = b;
            arrayB[slot] = b;
            arrayC[slot] = b;
            arrayD[slot] = b;
            arrayE[slot] = b;
            arrayF[slot] = b;
            arrayG[slot] = b;
            arrayH[slot] = b;
            arrayI[slot] = b;
            arrayJ[slot] = b;
            arrayK[slot] = b;
            arrayL[slot] = b;
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
            arrayE[slot] = b;
            arrayF[slot] = b;
        }
        i = ITERATIONS;
        while (--i != 0) {
            int slot = i & MASK;
            int b = i;
            arrayG[slot] = b;
            arrayH[slot] = b;
            arrayI[slot] = b;
            arrayJ[slot] = b;
            arrayK[slot] = b;
            arrayL[slot] = b;
        }
        return System.nanoTime() - start;
    }
}
