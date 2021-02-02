package com.pl1111w.datastructures.tree.leeCode;

/**
 * @title: pl1111w
 * @description: 判断是否二叉排序树
 * @author: Kris
 * @date 2021/2/2 22:46
 */
public class IsBinarySortTree {
    public static void main(String[] args) {
        IsBinarySortTree isBinarySortTree = new IsBinarySortTree();
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(8);
//        right.setLeft(new TreeNode(3));
//        right.setRight(new TreeNode(6));
        root.setLeft(left);
        root.setRight(right);
        boolean result = isBinarySortTree.isValidBST(root, null, null);
        System.out.println(result);
    }

    public boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int value = root.val;
        if (lower != null && root.val <= lower) {
            return false;
        }
        if (upper != null && root.val >= upper) {
            return false;
        }
        return isValidBST(root.left, lower, value) && isValidBST(root.right, value, upper);
    }
}
