package com.pl1111w.datastructures.sort;

import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: 桶排序
 * @author: Kris
 * @date 2020/11/3 21:49
 */
public class RadixSort {

    /**
     * 思路分析：
     * 首先创建十个的桶，分别放末尾数字0-9
     * 遍历数组获取最大值max，
     * 循环判断整个数组是否排列完毕：当最大值小于基准数dd（基准数从1开始每次扩大十倍）时，则说明整个数组已经拍完，
     * 每次循环取数组每位数进行取余数【(arr[i] / dd) % 10】，放入各个桶中，取出桶内元素对数组进行重排序，【清空桶】
     **/
    public static void main(String[] args) {
        int[] data = new int[]{1000, 319, 56, 785, 8, 61, 499, 212, 99};
        int[] result = sort(data);

        System.out.println(Arrays.toString(result));
    }

    private static int[] sort(int[] data) {

        int maxValue = data[0];
        for (int i = 0; i < data.length; i++) {
            if (data[i] > maxValue) {
                maxValue = data[i];
            }
        }
        int count = (maxValue + "").length();//比较轮数

        int[] bucketElementCounts = new int[10];
        int[][] bucket = new int[10][data.length];

        for (int i = 0, n = 1; i < count; i++, n *= 10) {
            for (int j = 0; j < data.length; j++) {
                int digitOfElement = data[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = data[j];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中，有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶(即第k个一维数组), 放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        data[index++] = bucket[k][l];
                    }
                }
                //第i+1轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
                bucketElementCounts[k] = 0;

            }
        }

        return data;
    }
}
