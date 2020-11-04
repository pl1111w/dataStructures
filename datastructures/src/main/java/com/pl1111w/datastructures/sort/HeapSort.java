package com.pl1111w.datastructures.sort;
import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: 堆排序
 * @author: Kris
 * @date 2020/11/4 22:03
 */
public class HeapSort {

    /***
     * 思路分析：
     * 1、首先遍历所有【从最后一个父节点开始向上遍历】父节点，
     * 与其子节点做比较，如果子节点值大于父节点，子节点与父节点交换位置
     * 2、将根节点调整到数组队尾
     * 3、剔除队尾元素重复步骤1，2；
     * */
    public static void main(String[] args) {
        int arr[] = {9, 2, 3, 6, 8, 7, 5, 4, 1, 10};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }
    }

    private static void swap(int[] arr, int i, int length) {
        int temp = arr[i];
        arr[i] = arr[length];
        arr[length] = temp;
    }

    private static void adjustHeap(int[] arr, int i, int length) {

        int temp = arr[i];
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j + 1] > arr[j]) {
                j++;
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
            arr[i] = temp;
        }
    }
}
