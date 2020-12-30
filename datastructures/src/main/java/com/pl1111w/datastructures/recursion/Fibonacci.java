package com.pl1111w.datastructures.recursion;

/**
 * @title: pl1111w
 * @description: 斐波那契数列
 * @author: Kris
 * @date 2020/12/30 22:40
 */
public class Fibonacci {
    public static void main(String[] args) {
        int total = fibonacci(6);
        int t = noRecusionFibonacci(6);
        System.out.println(total);
        System.out.println(t);
    }

    private static int fibonacci(int i) {
        if (i == 0 || i == 1) {
            return i;
        }
        if (i == 2) {
            return 1;
        }
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    private static int noRecusionFibonacci(int i) {
        if (i == 0 || i == 1) {
            return i;
        }
        int total = 0;
        int fn1 = 1;
        int fn2 = 0;
        for (int j = 1; j < i; j++) {
            total = fn1 + fn2;
            fn2 = fn1;
            fn1 = total;
        }
        return total;
    }

}
