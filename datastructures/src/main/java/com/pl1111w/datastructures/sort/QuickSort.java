package com.pl1111w.datastructures.sort;

import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: 快速排序
 * @author: Kris
 * @date 2020/10/30 21:20
 */
public class QuickSort {

    /**
     * 思路分析：
     * 1、选择数组第1个元素作为基准值
     * 2、从数组最后开始寻找小于基准的下标right停下来
     * 从数组头开始寻找找到大于基准的下标left停下来
     * arr[left],arr[right]交换位置
     * 3、重复2直到left=right【此时相遇】
     * 4、基准值下标与left(即right)交换位置
     * 此时left左边均为小于基准值的数，右边都是大于基准值的数
     * 5、 分为【两部分的数组】
     * 分别再次进行上述操作直到left不再小于right
     * 6、End
     **/

    public static void main(String[] args) {
        int arr[] = {9, 2, 3, 6, 8, 7, 5, 4, 1, 10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {

        int right = end;
        int left = start;
        if (start >= end) {
            return;
        }
        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] > temp) {
                right--;
            }
            while (left < right && arr[left] <= temp) {
                left++;
            }
            if (left < right) {
                int value = arr[left];
                arr[left] = arr[right];
                arr[right] = value;
            }
        }
        arr[start] = arr[left];
        arr[left] = temp;

        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);

    }
}
