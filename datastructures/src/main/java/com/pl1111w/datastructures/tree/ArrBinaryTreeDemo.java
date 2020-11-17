package com.pl1111w.datastructures.tree;

/**
 * @title: pl1111w
 * @description: 顺序化二叉树
 * @author: Kris
 * @date 2020/11/17 22:27
 */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        //创建一个 ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(); // 1,2,4,5,3,6,7
    }
}

class ArrBinaryTree {
    private int[] arr;//存储数据结点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    private void preOrder(int i) {
        if (arr == null) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }
        if (arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }
        System.out.println(arr[i]);
        if (i * 2 + 1 < arr.length) {
            preOrder(i * 2 + 1);
        }
        if (i * 2 + 2 < arr.length) {
            preOrder(i * 2 + 2);
        }
    }
}
