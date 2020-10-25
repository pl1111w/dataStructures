package com.pl1111w.datastructures.recursion;

/**
 * @title: pl1111w-递归回溯
 * @description: 八皇后
 * @author: Kris
 * @date 2020/10/24 16:23
 */
public class Queue8 {
    /**
     * 思路分析
     * 1、首先放置第1个皇后，共8个位置，依次遍历每个位置
     * 2、在放置第n(2<=n<=8)个皇后时候，首先遍历8个位置判断是否跟之前的皇后存在冲突
     * 3、若不存在冲突则直接摆放，否则调整n-1皇后位置【调整的皇后也需要判断冲突】，
     * 在进行第n个是否冲突的比较判断
     * 4、当第1个皇后位置遍历完成后，则开始遍历第2个皇后重复步骤2-3
     **/
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array, 保存皇后放置位置的结果,比如 arr = {0 , 4, 7, 5, 2, 6, 1, 3}
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法\n", count);
        System.out.printf("一共判断冲突的次数%d次", judgeCount); // 1.5w
    }

    private void check(int n) {
        if (n == max) {//n = 8 , 其实8个皇后就既然放好
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后 n , 放到该行的第1列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {
                //接着放n+1个皇后,即开始递归
                check(n + 1);
            }
            //如果冲突，就继续执行 array[n] = i; 即将第n个皇后，放置在本行得 后移的一个位置
        }


    }

    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
