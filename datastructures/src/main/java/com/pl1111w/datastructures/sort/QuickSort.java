package com.pl1111w.datastructures.sort;

import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: 快速排序 分成两拨计算
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
        int arr[] = {1, 7, 5, 3, 2, 4, 8, 6, 10, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);
            quickSort(arr, left, p - 1);
            quickSort(arr, p + 1, right);
        }
    }

    private static int partition(int[] arr, int low, int end) {

        int i = low;
        int j = end;
        int pv = arr[low];
        while (i < j) {
            //这两个while不能换位置
            while (arr[j] > pv && i < j) {
                j--;
            }
            //这两个while不能换位置
            while (arr[i] <= pv && i < j) {
                i++;
            }
            swap(arr, i, j);

        }
        swap(arr, i, low);
        //交换基准点
        return i;

    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
