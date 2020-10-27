package com.pl1111w.datastructures.sort;

import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: TODO
 * @author: Kris
 * @date 2020/10/27 22:14
 */
public class SelectSort {

    /**
     * 思路分析
     * 遍历数组找到最小的那个元素，记录下标，与第i（初始为0）个位置元素交换位置
     * i++ 继续遍历剩余元素
     **/
    public static void main(String[] args) {
        int arr[] = {9, 2, 3, 6, 8, 7, 5, 4, 1, 10};
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
