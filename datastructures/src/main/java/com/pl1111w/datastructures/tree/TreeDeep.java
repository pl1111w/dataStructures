package com.pl1111w.datastructures.tree;

import com.pl1111w.datastructures.tree.leeCode.TreeNode;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/8/10 15:25
 */
public class TreeDeep {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.getLeft());
        int right = maxDepth(root.getRight());
        return 1 + (Math.max(right, left));

    }
}
