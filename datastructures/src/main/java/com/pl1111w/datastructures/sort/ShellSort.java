package com.pl1111w.datastructures.sort;

import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: 希尔排序
 * @author: Kris
 * @date 2020/10/28 23:51
 */
public class ShellSort {
    /**
     * 思路分析：
     * 首先设置gap长度 一般为length/2
     * 以gap为宽度，遍历数组，如果前面的元素小于后面的元素交换位置
     * 遍历完成后gap=gap/2 继续上述步骤，不断小gap
     * 直到gap<=0结束；
     *
     * 移位法：不着急交换位置，判断所有gap之间的大小
     * 如果前面的值小于后面的值进行gap移位
     **/

    public static void main(String[] args) {
        int arr[] = {9, 2, 3, 6, 8, 7, 5, 4, 1, 10};
        shellSortBetter(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {

        int length = arr.length;
        int gap = length / 2;
        int temp;
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[gap + j]) {
                        temp = arr[j];
                        arr[j] = arr[gap + j];
                        arr[gap + j] = temp;
                    }
                }
            }
            gap = gap / 2;
        }
    }

    private static void shellSortBetter(int[] arr) {

        int length = arr.length;
        int gap = length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    //移位法
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }
                }
                arr[j] = temp;
            }
            gap = gap / 2;
        }
    }

}
