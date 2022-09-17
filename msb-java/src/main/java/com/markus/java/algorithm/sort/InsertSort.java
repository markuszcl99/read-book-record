package com.markus.java.algorithm.sort;

import com.markus.java.algorithm.util.SwapUtil;

/**
 * @author: markus
 * @date: 2022/9/17 3:19 PM
 * @Description: 插入排序
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1};
        insertSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    SwapUtil.swap(arr, j - 1, j);
                }
            }
        }
    }
}
