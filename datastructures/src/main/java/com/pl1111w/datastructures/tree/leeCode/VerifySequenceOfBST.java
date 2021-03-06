package com.pl1111w.datastructures.tree.leeCode;

/**
 * @title: pl1111w
 * @description: 判断一个数组是否是一个二叉排序树的后续遍历
 * @author: Kris
 * @date 2021/3/6 12:22
 */
public class VerifySequenceOfBST {

    public static void main(String[] args) {

        int[] nums = new int[]{9, 10, 8, 16, 18, 17, 15, 11};
        VerifySequenceOfBST test = new VerifySequenceOfBST();
        boolean result = test.isBinary(nums, 0, nums.length - 1);
        System.out.println(result);
    }

    public boolean isBinary(int[] nums, int start, int root) {

        if (start >= root)
            return true;
        int i = root;
        //从后开始，找到第一个该二叉树的左子树的节点位置
        while (i > start && nums[i - 1] > nums[root]) {
            i--;
        }
        //左子树的各节点都小于根节点
        for (int j = start; j < i; j++) {
            if (nums[j] > nums[root]) {
                return false;
            }
        }
        //递归判断数组是否为左右子树的后序遍历
        return (isBinary(nums, start, i - 1) && isBinary(nums, i, root - 1));

    }
}
