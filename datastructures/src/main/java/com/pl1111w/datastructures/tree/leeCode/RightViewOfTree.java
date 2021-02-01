package com.pl1111w.datastructures.tree.leeCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @title: pl1111w
 * @description: TODO
 * @author: Kris
 * @date 2021/2/1 21:48
 */
public class RightViewOfTree {

    public static void main(String[] args) {
        TreeNode parent = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(6);
        TreeNode leftNext = new TreeNode(2);
        TreeNode rightNext = new TreeNode(8);
        rightNext.setLeft(new TreeNode(7));
        rightNext.setRight(new TreeNode(9));
        right.setLeft(leftNext);
        right.setRight(rightNext);
        parent.setLeft(left);
        parent.setRight(right);

        List<Integer> list = rightViewOfTree(parent);
    }

    private static List<Integer> rightViewOfTree(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.getLeft() != null) {
                    queue.offer(treeNode.getLeft());
                }
                if (treeNode.getRight() != null) {
                    queue.offer(treeNode.getRight());
                }
                if (i == size - 1) {
                    System.out.println(treeNode.getVal());
                    list.add(treeNode.getVal());
                }
            }
        }
        return list;
    }
}
