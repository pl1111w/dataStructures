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

        ThreadHeroNode root = new ThreadHeroNode(1, "Java");
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

//        System.out.println("==========中序线索化开始=============");
//        System.out.println("｛8, 3, 10, 1, 14, 6｝");
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
//        threadedBinaryTree.midThreadedNodes();
//        ThreadHeroNode leftNode = node5.getLeft();
//        ThreadHeroNode rightNode = node5.getRight();
//        System.out.println("10号结点的前驱结点是 =" + leftNode); //3
//        System.out.println("10号结点的后继结点是=" + rightNode); //1
//
//        System.out.println("==========前序线索化开始=============");
//        System.out.println("｛1，3，8，10，6，14｝");
//        threadedBinaryTree.preThreadedNodes();
//        ThreadHeroNode preLeftNode = node4.getLeft();
//        ThreadHeroNode preRightNode = node4.getRight();
//        System.out.println("8号结点的前驱结点是 =" + preLeftNode); //3
//        System.out.println("8号结点的后继结点是=" + preRightNode); //10

        System.out.println("==========后序线索化开始=============");
        System.out.println("｛8，10，3, 14, 6，1｝");
        threadedBinaryTree.afterThreadedNodes();
        ThreadHeroNode afterLeftNode = node6.getLeft();
        ThreadHeroNode afterRightNode = node6.getRight();
        System.out.println("14号结点的前驱结点是 =" + afterLeftNode); //1
        System.out.println("14号结点的后继结点是=" + afterRightNode); //6

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

    public void preThreadedNodes() {
        this.preThreadedNodes(root);
    }

    private void preThreadedNodes(ThreadHeroNode node) {
        //如果node==null, 不能线索化
        if (node == null) {
            return;
        }
        //左指针为空,将左指针指向前驱节点
        //8结点的.left = 上一个节点 , 8结点的.leftType = 1
        if (node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }
        //处理后继结点,是下一次进行处理，有点不好理解
        if (pre != null && pre.getLeftType() == 1) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;
        //(一)先线索化左子树
        if (node.getLeftType() != 1) {
            preThreadedNodes(node.getLeft());
        }
        //(三)再线索化右子树
        if (node.getRightType() != 1) {
            preThreadedNodes(node.getRight());
        }

    }

    public void afterThreadedNodes() {
        this.afterThreadedNodes(root);
    }

    private void afterThreadedNodes(ThreadHeroNode node) {
        //如果node==null, 不能线索化
        if (node == null) {
            return;
        }
        afterThreadedNodes(node.getLeft());
        afterThreadedNodes(node.getRight());

        if (node.getLeft() == null) {
            node.setLeftType(1);
            node.setLeft(pre);
        }
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        pre = node;
    }
}
