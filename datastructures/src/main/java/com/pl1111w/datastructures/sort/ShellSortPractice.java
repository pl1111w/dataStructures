package com.pl1111w.datastructures.sort;

import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: TODO
 * @author: Kris
 * @date 2020/12/15 21:23
 */
public class ShellSortPractice {

    public static void main(String[] args) {
        int arr[] = {9, 2, 3, 6, 8, 7, 5, 4, 1, 10};
        shellSortBetter(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSortBetter(int[] arr) {

        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int value = arr[i];
                int j;
                for (j = i - gap; j >= 0 && arr[j] > value; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = value;
            }
            gap = gap / 2;
        }
    }
}
