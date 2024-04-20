package com.pl1111w.datastructures.sort;

import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: 归并排序
 * @author: Kris
 * @date 2020/11/1 11:55
 */
public class MergeSort {

    /***
     * 思路分析
     * 1、首先对数组进行两两分解直到不可分为止
     * 2、将拆分的数组进行复制然后进行排序
     * 3、当复制的数组左边的元素排序完成时候，直接将右边的元素复制到原数组中
     * 4、当复制的数组右边的元素排序完成时候，直接将左边的元素复制到原数组中
     * 5、当左边的元素(left)大于右边(right=middle+1)的元素，将右边的元素复制到原数组中
     * 6、否则将左边的元素复制到原数组中！
     * **/
    public static void main(String[] args) {
        int arr[] = {9, 2, 3, 8, 6, 7, 5, 4, 10, 1};
        int[] tempArr = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tempArr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end, int[] tempArr) {

        if (end <= start) {
            return;
        }
        int middleIndex = (end + start) / 2;
        mergeSort(arr, start, middleIndex, tempArr);
        mergeSort(arr, middleIndex + 1, end, tempArr);
        split(arr, start, middleIndex, end, tempArr);

    }
    //非递归
    private static void mergeSort2(int[] arr, int startIndex, int endIndex, int[] tempArr) {

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
