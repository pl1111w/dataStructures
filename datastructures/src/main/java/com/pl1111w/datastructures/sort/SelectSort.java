package com.pl1111w.datastructures.sort;

import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: 选择排序 每次确定一个最大或者最小位置
 * @author: Kris
 * @date 2020/10/27 22:14
 */
public class SelectSort {

    /**
     * 思路分析
     * 每轮遍历数组找到最小或者最大的那个元素，记录下这个位置 交换到合适位置
     * {2, 10, 3, 6, 8, 7, 5, 4, 1, 9}
     * 第一轮结束 确定位置1数值
     * {1, 10, 3, 6, 8, 7, 5, 4, 2, 9}
     **/
    public static void main(String[] args) {
        int arr[] = {2, 10, 3, 6, 8, 7, 5, 4, 1, 9};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = -1;
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index >= 0) {
                arr[index] = arr[i];
                arr[i] = min;
            }
        }

    }

}
