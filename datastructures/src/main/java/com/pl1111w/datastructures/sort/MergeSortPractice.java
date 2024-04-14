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

        int gap = 1;
        int length = arr.length ;
        while (gap < length) {
            //i += gap * 2 i每次跳到下一组
            for (int i = 0; i < length; i += gap * 2) {
                //要避免mid和right越界
                int mid = i + gap - 1;
                if (mid >= arr.length) {
                    mid = arr.length - 1;//修正越界的情况
                }
                int right = mid + gap;
                if (right >= arr.length) {//修正越界的情况
                    right = arr.length - 1;
                }
                split(arr, i, mid, right, tempArr);
            }
            gap *= 2;
        }
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
