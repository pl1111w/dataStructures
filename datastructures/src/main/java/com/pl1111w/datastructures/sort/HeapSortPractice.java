package com.pl1111w.datastructures.sort;

import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: 堆排序复习
 * @author: Kris
 * @date 2020/12/16 22:38
 */
public class HeapSortPractice {

    public static void main(String[] args) {
        int arr[] = {10, 2, 3, 6, 8, 7, 5, 4, 1, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(i, arr, arr.length);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(0, arr, i);
            adjustHeap(0, arr, i);
        }
    }

    private static void swap(int i, int[] arr, int end) {
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
    }

    private static void adjustHeap(int i, int[] arr, int length) {
        int value = arr[i];
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j + 1] > arr[j]) {
                j++;
            }
            if (value < arr[j]) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
            arr[i] = value;
        }
    }
}
