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
        int arr[] = {9, 2, 3, 6, 8, 7, 5, 4, 1, 10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int end) {

        int right = end;
        int left = low;
        if (low >= end) {
            return;
        }
        int value = arr[left];
        while (left < right) {
            while (left < right && arr[right] > value) {
                right--;
            }
            while (left < right && arr[left] <= value) {
                left++;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[low] = arr[left];
        arr[left] = value;
        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, end);
    }
}
