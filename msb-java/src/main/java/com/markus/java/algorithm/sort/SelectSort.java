package com.markus.java.algorithm.sort;

import com.markus.java.algorithm.util.SwapUtil;

/**
 * @author: markus
 * @date: 2022/9/17 3:19 PM
 * @Description: 选择排序
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1};
        selectSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            SwapUtil.swap(arr, i, minValueIndex);
        }
    }
}
