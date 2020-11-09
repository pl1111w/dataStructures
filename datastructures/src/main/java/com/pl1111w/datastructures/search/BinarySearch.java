package com.pl1111w.datastructures.search;

/**
 * @title: pl1111w-查找
 * @description: 二分查找
 * @author: Kris
 * @date 2020/11/9 22:23
 */
public class BinarySearch {
    public static void main(String[] args) {

        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
        int index = binarySearch(arr, 0, arr.length - 1, 1234);
        System.out.println(index);

    }

    private static int binarySearch(int[] arr, int start, int end, int value) {

        int begin = start;
        int last = end;
        int index = -1;
        while (begin <= last) {
            int middle = (begin + last) / 2;
            if (arr[middle] == value) {
                index = middle;
                break;
            } else if (arr[middle] > value) {
                last = middle - 1;
            } else {
                begin = middle + 1;
            }
        }
        return index;
    }
}
