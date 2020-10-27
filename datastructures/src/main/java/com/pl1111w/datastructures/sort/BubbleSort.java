package com.pl1111w.datastructures.sort;

import java.util.Arrays;

/**
 * @title: pl1111w-排序算法
 * @description: 冒泡排序
 * @author: Kris
 * @date 2020/10/27 21:35
 */
public class BubbleSort {

    /**
     * 思路分析：
     * 从头开始依次遍历数组每个元素
     * 如果前面的元素大于后面的元素则交换位置,
     * 直到数组最后一个位置，找到最大的一个元素
     **/
    public static void main(String[] args) {
        int arr[] = {9, 2, 3, 6, 8, 7, 5, 4, 1, 10};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        int temp;
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] > arr[j]) {
//                    temp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = temp;
//                }
//            }
//        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
