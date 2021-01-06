package com.pl1111w.datastructures.tree.leeCode;

/**
 * @title: pl1111w
 * @description: 判断是否子树
 * @author: Kris
 * @date 2021/1/6 20:38
 */
public class IsChildTreeNode {
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

        TreeNode child = new TreeNode(6);
        TreeNode childLeft = new TreeNode(2);
        TreeNode childRight = new TreeNode(8);
        child.setLeft(childLeft);
        child.setRight(childRight);
        boolean isChild = isChildTreeNode(parent, child);
        System.out.println("isChild: " + isChild);


    }

    private static boolean isChildTreeNode(TreeNode parent, TreeNode child) {
        if (child == null || parent == null) {
            return false;
        }
        return isSub(parent, child) || isSubStructure(parent.getLeft(), child) || isSubStructure(parent.getRight(), child);
    }

    private static boolean isSub(TreeNode parent, TreeNode child) {

        if (child == null) {
            return true;
        }
        if (parent == null || parent.getVal() != child.getVal()) {
            return false;
        }
        return isSub(parent.getLeft(), child.getLeft())
                && isSub(parent.getRight(), child.getRight());
    }

    private static boolean isSubStructure(TreeNode next, TreeNode child) {

        if (next == null || child == null) {
            return false;
        }
        if (next.getVal() == child.getVal()) {
            return isSub(next, child);
        }
        return isChildTreeNode(next.getLeft(), child) || isChildTreeNode(next.getRight(), child);
    }

}
