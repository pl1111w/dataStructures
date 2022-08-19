package com.pl1111w.datastructures.tree.leeCode;

/**
 * @title: pl1111w
 * @description: 对称树
 * @author: Kris
 * @date 2021/1/10 17:32
 */
public class Symmetric {

    public static void main(String[] args) {
        TreeNode parent = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(3);
        left.setLeft(new TreeNode(4));
        right.setLeft(new TreeNode(2));
        left.setRight(new TreeNode(2));
        right.setRight(new TreeNode(4));
        parent.setRight(right);
        parent.setLeft(left);
        boolean isSymmetric = isSymmetric(parent.getLeft(), parent.getRight());
        System.out.println("是否是对称树：" + isSymmetric);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {

        if (left != null && right == null) {
            return false;
        }
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right != null && left.getVal() != right.getVal()) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        return isSymmetric(left.getLeft(), right.getRight()) && isSymmetric(left.getRight(), right.getLeft());
    }

    public boolean isSymmetric(TreeNode root) {
        if(root!=null && root.left!=null && root.right!=null)
            return judgeSymmetric(root.left,root.right);
        else return false;
    }
    public boolean judgeSymmetric(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left!=null && right==null){
            return false;
        }
        if(left == null){
            return false;
        }
        if(left.val!=right.val)
            return false;
        if(left.right!=null && right.left!=null){
            if(left.right.val!=right.left.val)
                return false;
        }
        if(left.left!=null && right.right!=null){
            if(left.left.val!=right.right.val)
                return false;
        }
        return judgeSymmetric(left.left,right.right) && judgeSymmetric(left.right,right.left);
    }
}
