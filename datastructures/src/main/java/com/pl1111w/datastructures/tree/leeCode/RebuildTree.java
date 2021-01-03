package com.pl1111w.datastructures.tree.leeCode;

/**
 * @title: pl1111w
 * @description: 通过先序遍历中序遍历构建二叉树
 * @author: Kris
 * @date 2020/12/30 22:36
 */
public class RebuildTree {

    static int pre = 0;
    static int in = 0;

    public static void main(String[] args) {

        int[] preOrder = {3, 9, 8, 5, 2, 20, 15, 7};
        int[] inOrder = {5, 8, 9, 2, 3, 15, 20, 7};
        TreeNode treeNode = rebuildTree(0, 0, inOrder.length - 1, preOrder, inOrder);
        System.out.println(treeNode);
        TreeNode treeNode2 = rebuildTree2(inOrder.length - 1, preOrder, inOrder);
        System.out.println(treeNode2);
    }

    private static TreeNode rebuildTree(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder) {
        if (preStart > preOrder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preOrder[preStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == node.getVal()) {
                index = i;
                break;
            }
        }
        node.setLeft(rebuildTree(preStart + 1, inStart, index - 1, preOrder, inOrder));
        node.setRight(rebuildTree(preStart + index - inStart + 1, index + 1, inEnd, preOrder, inOrder));
        return node;
    }

    private static TreeNode rebuildTree2(int inEnd, int[] preOrder, int[] inOrder) {
        if (pre > preOrder.length - 1) {
            return null;
        }

        if (inOrder[in] == inEnd) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preOrder[pre++]);
        node.setLeft(rebuildTree2(node.getVal(), preOrder, inOrder));
        node.setRight(rebuildTree2(inEnd, preOrder, inOrder));
        return node;
    }
}
