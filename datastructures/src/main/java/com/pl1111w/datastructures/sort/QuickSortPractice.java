package com.pl1111w.datastructures.sort;

import javax.xml.crypto.Data;
import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: 快速排序
 * @author: Kris
 * @date 2020/12/16 21:35
 */
public class QuickSortPractice {

    public static void main(String[] args) {
        int arr[] = {8, 2, 3, 6, 9, 7, 5, 4, 1, 10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        int low = left;
        int end = right;
        while (low < end) {
            int temp = arr[low];
            for (int i = 0; i < arr.length - 1; i++) {
                if (temp > arr[low] && low < end) {
                    low++;
                } else if (temp > arr[end] && end > low) {
                    end--;
                } else {
                    break;
                }
            }
            arr[low] = arr[end];
            arr[end] = temp;
            quickSort(arr, left, low - 1);
            quickSort(arr, end + 1, right);
        }

    }
}
