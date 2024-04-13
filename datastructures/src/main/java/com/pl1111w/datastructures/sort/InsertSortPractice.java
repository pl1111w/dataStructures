package com.pl1111w.datastructures.sort;

import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: 插入排序复习
 * @author: Kris
 * @date 2020/12/16 22:27
 */
public class InsertSortPractice {

    public static void main(String[] args) {
        int arr[] = {9, 2, 3, 6, 8, 7, 5, 4, 1, 10};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (temp > arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }
}
