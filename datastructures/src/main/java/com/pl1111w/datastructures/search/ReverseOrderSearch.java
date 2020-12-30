package com.pl1111w.datastructures.search;

/**
 * @title: pl1111w
 * @description: 有序数组旋转一次查找最小元素
 * @author: Kris
 * @date 2020/12/30 21:41
 */
public class ReverseOrderSearch {

    public static void main(String[] args) {
        int[] numbers = {6, 7, 8, 9, 1, 2, 3, 4, 5};
        //int[] numbers = {7, 7, 7, 7, 7, 7, 1, 1, 1};
        int result = reverseOrderSearch(numbers);
        System.out.println("旋转一次的最小数组元素是：" + result);
    }

    private static int reverseOrderSearch(int[] numbers) {

        int start = 0;
        int end = numbers.length - 1;
        int middle;
        while (start < end) {
            middle = (start + end) / 2;
            if (numbers[middle] < numbers[end]) {
                end = middle;
            } else if (numbers[middle] > numbers[end]) {
                start = middle + 1;
            } else {
                end--;//元素相等时
            }
        }
        return numbers[end];//end=start
    }
}
