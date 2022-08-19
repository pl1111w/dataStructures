package com.pl1111w.datastructures.tree.leeCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        addLevel(root, 0, list);
        return list;

    }

    public void addLevel(TreeNode root, int level, List<List<Integer>> lists) {
        if (root == null) {
            return;
        }
        if (lists.size() < level + 1) {
            lists.add(new ArrayList<Integer>());
        }
        lists.get(level).add(root.val);
        addLevel(root.left, level + 1, lists);
        addLevel(root.right, level + 1, lists);

    }

    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        left.setLeft(new TreeNode(4));
        right.setRight(new TreeNode(5));

        root.setLeft(left);
        root.setRight(right);
        List<List<Integer>> lists = levelOrder.levelOrder(root);
        System.out.println(lists);
    }
}