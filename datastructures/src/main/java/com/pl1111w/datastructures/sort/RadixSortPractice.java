package com.pl1111w.datastructures.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @title: pl1111w
 * @description: 桶排序复习
 * @author: Kris
 * @date 2020/12/16 20:52
 */
public class RadixSortPractice {

    public static void main(String[] args) {
        int[] data = new int[]{1000, 319, 56, 785, 8, 61, 499, 212, 99};
        int[] result = sortRadix(data);

        System.out.println(Arrays.toString(result));
    }

    private static int[] sortRadix(int[] data) {

        int max = data[0];
        for (int i = 0; i < data.length; i++) {
            if (max < data[i]) {
                max = data[i];
            }
        }
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }
        int mark = 1, location = 10;
        while (mark <= max) {
            for (int j = 0; j < data.length; j++) {
                bucketList.get(data[j] / mark % location).add(data[j]);
            }
            for (ArrayList list : bucketList) {
                Collections.sort(list);
            }
            int index = 0;

            for (ArrayList list : bucketList) {
                Collections.sort(list);
            }
            for (ArrayList<Integer> list : bucketList) {
                for (int i = 0; i < list.size(); i++) {
                    data[index] = list.get(i);
                    index++;
                }
                list.clear();
            }

            mark = mark * location;
        }
        return data;
    }
}
