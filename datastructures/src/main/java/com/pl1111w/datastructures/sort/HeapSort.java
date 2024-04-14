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
     * 1、首先遍历所有i=[0 ~ arr.length/2-1]个父节点，
     * 与其子节点【i*2+1 || i* 2 +2】做比较，
     * 如果子节点【需要先判断左右子节点大小，取大值】
     * 值大于父节点，子节点与父节点交换位置
     * 2、将根节点调整到数组队尾【队尾最大值】
     * 3、剔除队尾元素,遍历剩余节点，对根节点进行堆调整，即重复步骤1，2；
     * */
    public static void main(String[] args) {
        int arr[] = {10, 2, 3, 6, 8, 7, 5, 4, 1, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {

        for (int i = 0; i < arr.length / 2; i = i * 2 + 1) {
            adjustHeap(i, arr, arr.length);
        }
        System.out.println("构建堆完毕： " + Arrays.toString(arr));
        for (int j = arr.length - 1; j > 0; j--) {
            swap(0, j, arr);
            adjustHeap(0, arr, j);
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void adjustHeap(int i, int[] arr, int length) {
        int temp = arr[i];//拿到父元素

        //找到子元素
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            //查看左右子树 找到值更大的一个与父节点交换
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
