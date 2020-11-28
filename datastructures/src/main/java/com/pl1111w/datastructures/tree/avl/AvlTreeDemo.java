package com.pl1111w.datastructures.tree.avl;

/**
 * @title: pl1111w
 * @description: 平衡二叉树
 * @author: Kris
 * @date 2020/11/28 11:17
 */
public class AvlTreeDemo {

    public static void main(String[] args) {

        int[] arr = {4, 3, 6, 5, 7, 8};
        AvlTree avlTree = new AvlTree();
        //循环的添加结点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历二叉树");
        avlTree.infixOrder();
        System.out.println("二叉树高度为:" + avlTree.getRoot().height());
        System.out.println("二叉树左子树高度为:" + avlTree.getRoot().leftHeight());
        System.out.println("二叉树右子树高度为:" + avlTree.getRoot().rightHeight());

    }
}

class AvlTree {
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root == null) {
            return;
        } else {
            root.infixOrder();
        }
    }
}


class Node {

    private int value;

    private Node left;

    private Node right;

    public Node(int value) {
        this.value = value;
    }

    // 返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    // 返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "value=" + value +
                '}';
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left != null) {
                this.left.add(node);
            } else {
                this.left = node;
            }
        } else {
            if (this.right != null) {
                this.right.add(node);
            } else {
                this.right = node;
            }
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public int height() {
        return Math.max(this.left == null ? 0 : this.left.height(),
                this.right == null ? 0 : this.right.height()) + 1;
    }
}
