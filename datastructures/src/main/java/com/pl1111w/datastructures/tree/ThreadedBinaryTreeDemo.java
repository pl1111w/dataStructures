package com.pl1111w.datastructures.tree;

import lombok.Data;

/**
 * @title: pl1111w
 * @description: 线索化二叉树
 * @author: Kris
 * @date 2020/11/21 9:39
 */
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {

        ThreadHeroNode root = new ThreadHeroNode(1, "java");
        ThreadHeroNode node2 = new ThreadHeroNode(3, "C#");
        ThreadHeroNode node3 = new ThreadHeroNode(6, "Python");
        ThreadHeroNode node4 = new ThreadHeroNode(8, "C++");
        ThreadHeroNode node5 = new ThreadHeroNode(10, "GO");
        ThreadHeroNode node6 = new ThreadHeroNode(14, "php");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        System.out.println("==========中序线索化开始=============");
        System.out.println("｛8, 3, 10, 1, 14, 6｝");
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.midThreadedNodes();

        ThreadHeroNode leftNode = node5.getLeft();
        ThreadHeroNode rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是 =" + leftNode); //3
        System.out.println("10号结点的后继结点是=" + rightNode); //1
    }
}

@Data
class ThreadHeroNode {
    private int no;
    private String name;
    /**
     * //默认null
     */
    private ThreadHeroNode left;
    /**
     * //默认null
     */
    private ThreadHeroNode right;

    /**
     * //父节点的指针（为了后序线索化使用）
     */
    private ThreadHeroNode parent;

    /**
     * //说明
     * //1. 如果leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
     * //2. 如果rightType == 0 表示指向是右子树, 如果 1表示指向后继结点
     */
    private int leftType;
    private int rightType;

    public ThreadHeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ThreadHeroNode [no=" + no + ", name=" + name + "]";
    }

}

@Data
class ThreadedBinaryTree {

    ThreadHeroNode root;

    ThreadHeroNode pre = null;

    public void midThreadedNodes() {

        if (root == null) {
            System.out.println("空树");
            return;
        } else {
            this.midThreadedNodes(root);
        }
    }

    public void midThreadedNodes(ThreadHeroNode node) {
        if (node == null) {
            return;
        }
        midThreadedNodes(node.getLeft());
        if (node.getLeft() == null) {
            node.setLeftType(1);
            node.setLeft(pre);
        }
        //接下来判断前一个节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        midThreadedNodes(node.getRight());
    }
}
