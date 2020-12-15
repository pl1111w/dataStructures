package com.pl1111w.datastructures.tree.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @title: pl1111w
 * @description: 赫夫曼树
 * @author: Kris
 * @date 2020/11/22 12:54
 */
public class HuffmanTreeDemo {

    public static void main(String[] args) {

        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        preOrder(root); //
    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树，不能遍历~~");
        }
    }


    private static Node createHuffmanTree(int[] arr) {
        // 第一步为了操作方便
        // 1. 遍历 arr 数组
        // 2. 将arr的每个元素构成成一个Node
        // 3. 将Node 放入到ArrayList中
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        //我们处理的过程是一个循环的过程


        while (nodes.size() > 1) {

            //排序 从小到大
            Collections.sort(nodes);

            System.out.println("nodes =" + nodes);

            //取出根节点权值最小的两颗二叉树
            //(1) 取出权值最小的结点（二叉树）
            Node leftNode = nodes.get(0);
            //(2) 取出权值第二小的结点（二叉树）
            Node rightNode = nodes.get(1);

            //(3)构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //(4)从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //(5)将parent加入到nodes
            nodes.add(parent);
        }

        //返回哈夫曼树的root结点
        return nodes.get(0);
    }
}

class Node implements Comparable<Node> {

    int value;

    Node left;

    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [value = " + value + "]";
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

}