package com.pl1111w.datastructures.sort;

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
        if (left >= right) return;
        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pv = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (arr[j] > pv && i < j) {
                j--;
            }
            while (arr[i] <= pv && i <j) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, j, left);
        //交换基准点
        return j;

    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
