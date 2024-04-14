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
        int middleIndex = (startIndex + endIndex) / 2;
        mergeSort(arr, startIndex, middleIndex, tempArr);
        mergeSort(arr, middleIndex + 1, endIndex, tempArr);
        split(arr, startIndex, middleIndex, endIndex, tempArr);

    }

    private static void split(int[] arr, int start, int middle, int end, int[] tempArr) {
        for (int i = start; i <= end; i++) {
            tempArr[i] = arr[i];
        }
        int left = start;
        int right = middle + 1;
        for (int i = start; i <= end; i++) {
            if (left > middle) {
                arr[i] = tempArr[right++];
            } else if (right > end) {
                arr[i] = tempArr[left++];
            } else if (tempArr[right] < tempArr[left]) {
                arr[i] = tempArr[right++];
            } else {
                arr[i] = tempArr[left++];
            }
        }
    }
}
