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

        int startIndex = start;
        int endIndex = end;
        if (endIndex <= startIndex) {
            return;
        }
        int middleIndex = (endIndex + startIndex) / 2;
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
