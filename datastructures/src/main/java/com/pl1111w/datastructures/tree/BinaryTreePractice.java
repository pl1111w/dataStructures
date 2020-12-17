package com.pl1111w.datastructures.tree;

/**
 * @title: pl1111w
 * @description: 二叉树练习
 * @author: Kris
 * @date 2020/12/17 21:21
 */
public class BinaryTreePractice {
    public static void main(String[] args) {

        StackNode root = new StackNode(1, "罗伯");
        StackNode node2 = new StackNode(2, "萨沙");
        StackNode node3 = new StackNode(3, "艾丽娅");
        StackNode node4 = new StackNode(4, "布兰");
        StackNode node5 = new StackNode(5, "瑞肯");

        BinaryPracticeTree binaryPracticeTree = new BinaryPracticeTree();
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);
        binaryPracticeTree.setRoot(root);
        binaryPracticeTree.preOrder();
        System.out.println("中序查找指定节点");
        StackNode node = binaryPracticeTree.searchMiddleOrder(4);
        System.out.println(node);
    }
}

class BinaryPracticeTree {
    private StackNode root;

    public void setRoot(StackNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public StackNode searchMiddleOrder(int id) {
        if (this.root != null) {
            return this.root.searchMiddleOrder(id);
        } else {
            return null;
        }
    }
}

class StackNode {

    private int id;
    private String name;

    private StackNode left;

    public StackNode getLeft() {
        return left;
    }

    public void setLeft(StackNode left) {
        this.left = left;
    }

    public StackNode getRight() {
        return right;
    }

    public void setRight(StackNode right) {
        this.right = right;
    }

    private StackNode right;

    public StackNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public StackNode searchMiddleOrder(int id) {
        StackNode stackNode = null;
        if (this.left != null) {
            stackNode = this.left.searchMiddleOrder(id);
        }
        //找到了
        if (stackNode != null) {
            return stackNode;
        }
        if (this.id == id) {
            return this;
        }
        if (this.right != null) {
            stackNode = this.right.searchMiddleOrder(id);
        }
        return stackNode;
    }
}
