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
     * 选择数组第1个元素，如果第个2元素小于第1个元素
     * 则第1个元素后移一位,第2个元素放到第1个元素位置
     * 否则直接放到第1个元素后面，此时排序完成数组长度+1
     * 继续判断第3个元素如果第3个元素小于第1个元素
     * 则第1，2个都向后挪一位
     * 依次类推
     ***/

    public static void main(String[] args) {
        int arr[] = {9, 2, 3, 6, 8, 7, 5, 4, 1, 10};
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
            arr[j] = temp;
        }
    }
}
