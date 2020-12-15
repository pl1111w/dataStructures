package com.pl1111w.datastructures.sort;

import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: TODO
 * @author: Kris
 * @date 2020/12/15 21:41
 */
public class MergeSortPractice {
    public static void main(String[] args) {
        int arr[] = {9, 2, 3, 8, 6, 7, 5, 4, 10, 1};
        int[] tempArr = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tempArr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int startIndex, int endIndex, int[] tempArr) {
        if (startIndex >= endIndex) {
            return;
        }
        int middle = startIndex + (endIndex - startIndex) / 2;
        mergeSort(arr, startIndex, middle, tempArr);
        mergeSort(arr, middle + 1, endIndex, tempArr);
        merge(arr, tempArr, startIndex, middle, endIndex);
    }

    private static void merge(int[] arr, int[] tempArr, int startIndex, int middle, int endIndex) {
        for (int copy = startIndex; copy <= endIndex; copy++) {
            tempArr[copy] = arr[copy];
        }
        int left = startIndex;
        int right = middle + 1;
        for (int i = startIndex; i <= endIndex; i++) {
            if (left > middle) {
                arr[i] = tempArr[right++];
            } else if (right > endIndex) {
                arr[i] = tempArr[left++];
            } else if (tempArr[left] < tempArr[right]) {
                arr[i] = tempArr[left++];
            } else {
                arr[i] = tempArr[right++];
            }
        }
    }
}
