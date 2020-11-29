package com.pl1111w.datastructures.tree.avl;

/**
 * @title: pl1111w
 * @description: 平衡二叉树
 * @author: Kris
 * @date 2020/11/28 11:17
 */
public class AvlTreeDemo {

    public static void main(String[] args) {

//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 12, 8, 9, 7, 6};
//        int[] arr = { 10, 11, 7, 6, 8, 9 };
        int[] arr = {9, 8, 10, 11, 7, 12, 6};
        AvlTree avlTree = new AvlTree();
        //循环的添加结点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历二叉树");
        System.out.println(avlTree.getRoot());
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
        //当添加完一个结点后，如果: (右子树的高度-左子树的高度) > 1 , 左旋转
        if (rightHeight() - leftHeight() > 1) {
            //如果它的右子树的左子树的高度大于它的右子树的右子树的高度
            if (right != null && right.leftHeight() > right.rightHeight()) {
                //先对右子结点进行右旋转
                right.rightRotate();
                //然后在对当前结点进行左旋转
                leftRotate(); //左旋转..
            } else {
                //直接进行左旋转即可
                leftRotate();
            }
            // return ; //必须要!!!
        }

        //当添加完一个结点后，如果 (左子树的高度 - 右子树的高度) > 1, 右旋转
        else if (leftHeight() - rightHeight() > 1) {
            //如果它的左子树的右子树高度大于它的左子树的高度
            if (left != null && left.rightHeight() > left.leftHeight()) {
                //先对当前结点的左结点(左子树)->左旋转
                left.leftRotate();
                //再对当前结点进行右旋转
                rightRotate();
            } else {
                //直接进行右旋转即可
                rightRotate();
            }
        }
    }

    private void rightRotate() {
        Node newNode = new Node(this.value);
        newNode.right = right;
        newNode.left = this.left.right;
        this.value = left.value;
        this.left = this.left.left;
        this.right = newNode;
    }

    private void leftRotate() {
        Node newNode = new Node(this.value);
        newNode.left = left;
        newNode.right = right.left;
        this.value = right.value;
        this.right = right.right;
        this.left = newNode;
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
        System.out.println("value:"+this.value);
        return Math.max(this.left == null ? 0 : this.left.height(),
                this.right == null ? 0 : this.right.height()) + 1;
    }
}
