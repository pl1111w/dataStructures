package com.pl1111w.datastructures.search;

/**
 * @title: pl1111w-查找
 * @description: 插值查找
 * @author: Kris
 * @date 2020/11/9 22:38
 */
public class InsertValueSearch {

    public static void main(String[] args) {

        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
        int index = insertValueSearch(arr, 0, arr.length - 1, 1234);
        System.out.println(index);

    }

    private static int insertValueSearch(int[] arr, int start, int end, int value) {

        if (start > end || value < arr[start] || value > arr[end]) {
            return -1;
        }
        int middle = start + (value - arr[start]) / (arr[end] - arr[start]) * (end - start);
        if (arr[middle] < value) {
            return insertValueSearch(arr, middle + 1, end, value);
        } else if (arr[middle] > value) {
            return insertValueSearch(arr, start, middle - 1, value);
        } else {
            return middle;
        }

    }
}
