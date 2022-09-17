package com.markus.java.algorithm.sort;

import com.markus.java.algorithm.util.SwapUtil;

/**
 * @author: markus
 * @date: 2022/9/17 3:20 PM
 * @Description: 冒泡排序
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SwapUtil.swap(arr, j, j + 1);
                }
            }
        }
    }
}
