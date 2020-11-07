package com.pl1111w.datastructures.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @title: pl1111w
 * @description: 桶排序
 * @author: Kris
 * @date 2020/11/7 17:18
 */
public class BarrelSort {

    public static void main(String[] args) {
        int[] arr = new int[]{-20, 32, 100, 47, 68, 28, 86, 54, 13, 0};
        int[] result = barrelSort(arr);

        System.out.println(Arrays.toString(result));
    }

    private static int[] barrelSort(int[] arr) {

        //最大最小值
        int max = arr[0];
        int min = arr[0];
        int length = arr.length;

        for (int i = 1; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        //最大值和最小值的差
        int diff = max - min;
        //每个桶的存数区间
        float section = (float) diff / (float) (length);
        //桶列表
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < max / section; i++) {
            bucketList.add(new ArrayList<>());
        }

        for (int i = 0; i < length; i++) {
            //当前数除以区间得出存放桶的位置
            int num = (int) (arr[i] / section);
            if (num >= bucketList.size()) {
                num = bucketList.size() - 1;
            }
            if (num < 0) {
                num = 0;
            }
            bucketList.get(num).add(arr[i]);
        }

        //桶内排序
        for (int i = 0; i < bucketList.size(); i++) {
            //jdk的排序速度当然信得过
            Collections.sort(bucketList.get(i));
        }

        //写入原数组
        int index = 0;
        for (ArrayList<Integer> arrayList : bucketList) {
            for (int value : arrayList) {
                arr[index] = value;
                index++;
            }
        }

        return arr;
    }

}
