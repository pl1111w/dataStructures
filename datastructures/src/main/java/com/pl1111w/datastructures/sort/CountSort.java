package com.pl1111w.datastructures.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title: pl1111w
 * @description: 计数排序
 * @author: Kris
 * @date 2020/11/7 13:08
 */
public class CountSort {

    /**
     * 计数排序适合正整数且范围差距不大
     **/
    public static void main(String[] args) {
        int[] data = new int[]{81, 85, 85, 87, 84, 82, 84, 82, 89};
        int[] result = sort(data);
        System.out.println(Arrays.toString(result));
    }

    private static int[] sort(int[] data) {

        int min = data[0];
        int max = data[0];
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
            if (data[i] < min) {
                data[i] = min;
            }
        }
        int length = max - min;
        List<ArrayList<Integer>> lists = new ArrayList<>(length);
        for (int k = 0; k < length; k++) {
            lists.add(new ArrayList<>());
        }
        for (int j = 0; j < data.length; j++) {
            if (data[j] - min == lists.size()) {
                lists.get(data[j] - min - 1).add(data[j]);
            } else {
                lists.get(data[j] - min).add(data[j]);
            }

        }
        int index = 0;
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> integerList = lists.get(i);
            for (int j = 0; j < integerList.size(); j++) {
                data[index] = integerList.get(j);
                index++;
            }
        }

        return data;
    }
}
