package com.pl1111w.datastructures.sort;

import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: 选择排序复习
 * @author: Kris
 * @date 2020/12/16 20:43
 */
public class SelectSortPractice {

    public static void main(String[] args) {
        int arr[] = {10, 2, 3, 6, 8, 7, 5, 4, 1, 9};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            arr[i] = arr[index];
            arr[index] = value;
        }

    }
}
