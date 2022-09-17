package com.markus.java.algorithm.util;

/**
 * @author: markus
 * @date: 2022/9/17 3:21 PM
 * @Description: 交换工具类
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SwapUtil {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
