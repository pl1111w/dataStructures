package com.pl1111w.datastructures.tree.leeCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @title: pl1111w
 * @description: 镜像树
 * @author: Kris
 * @date 2021/1/8 21:09
 */
public class MirrorTree {

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
        TreeNode node = mirrorTree(parent);
        System.out.println(node);
        TreeNode nodeBFS = mirrorTreeBFS(parent);
        System.out.println(nodeBFS);
    }

    private static TreeNode mirrorTree(TreeNode parent) {

        if (parent == null) {
            return null;
        }
        TreeNode temp = parent.getLeft();
        parent.setLeft(parent.getRight());
        parent.setRight(temp);

        mirrorTree(parent.getLeft());
        mirrorTree(parent.getRight());

        return parent;
    }

    private static TreeNode mirrorTreeBFS(TreeNode parent) {
        TreeNode root = parent;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
            TreeNode temp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);
        }
        return parent;
    }
}
