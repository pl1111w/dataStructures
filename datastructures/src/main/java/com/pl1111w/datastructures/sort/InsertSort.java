package com.pl1111w.datastructures.sort;

import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: 插入排序
 * @author: Kris
 * @date 2020/10/28 20:10
 */
public class InsertSort {

    /**
     * 思路分析：
     * 选择数组第i（>=1）个元素，如果满足前i-1元素大于第i个元素
     * 把坐标i-1的值置为下标i的值
     * 跳出循环
     * 【排序完成数组长度第1，2】个都向后挪一位
     *
     *
     * 继续判断第i+1个元素
     * 依次类推
     ***/

    public static void main(String[] args) {
        int arr[] = {5, 2, 6, 3, 8, 7, 9, 4, 1, 10};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {

                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];//挪位置
                } else {
                    break;//跳出循环，开始插入下一个数
                }
            }
            arr[j + 1] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }
}
