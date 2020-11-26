package com.pl1111w.datastructures.tree.binarySortTree;

/**
 * @title: pl1111w
 * @description: 二叉排序树
 * @author: Kris
 * @date 2020/11/25 20:36
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环的添加结点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树~");
        binarySortTree.infixOrder(); // 1, 2, 3, 5, 7, 9, 10, 12
        binarySortTree.delNode(2);
        binarySortTree.delNode(3);
        binarySortTree.delNode(5);
        binarySortTree.delNode(1);
        binarySortTree.delNode(9);
        binarySortTree.delNode(10);
        binarySortTree.delNode(7);
        System.out.println("root=" + binarySortTree.getRoot());
        System.out.println("删除后，中序遍历二叉排序树~");
        binarySortTree.infixOrder();
    }
}

class BinarySortTree {
    Node root;

    //添加结点的方法
    public void add(Node node) {
        if (root == null) {
            root = node;//如果root为空则直接让root指向node
        } else {
            root.addNode(node);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.midOrderBinarySortTree();
        } else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }

    public Node searchNode(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchNode(value);
        }
    }

    public Node parentNode(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    public void delNode(int value) {
        if(root == null) {
            return;
        }else {
            //1.需求先去找到要删除的结点  targetNode
            Node target = searchNode(value);
            //如果没有找到要删除的结点
            if(target == null) {
                return;
            }
            //如果我们发现当前这颗二叉排序树只有一个结点
            if(root.left == null && root.right == null) {
                root = null;
                return;
            }

            //去找到targetNode的父结点
            Node parent = parentNode(value);

            //删除的是子节点
            if (target.left == null && target.right == null) {
                //判断targetNode 是父结点的左子结点，还是右子结点
                if (parent.left != null && parent.left.value == value) { //是左子结点
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {//是由子结点
                    parent.right = null;
                }
            } else if (target.left != null && target.right != null) { //删除有两颗子树的节点
                int minVal = delRightTreeMin(target.right);
                target.value = minVal;
            } else { // 删除只有一颗子树的结点
                //如果要删除的结点有左子结点
                if (target.left != null) {
                    if (parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if (parent.left.value == value) {
                            parent.left = target.left;
                        } else { //  targetNode 是 parent 的右子结点
                            parent.right = target.left;
                        }
                    } else {
                        root = target.left;
                    }
                } else { //如果要删除的结点有右子结点
                    if (parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if (parent.left!=null && parent.left.value == value) {
                            parent.left = target.right;
                        } else { //如果 targetNode 是 parent 的右子结点
                            parent.right = target.right;
                        }
                    } else {
                        root = target.right;
                    }
                }

            }
        }

    }

    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左子节点，就会找到最小值
        while (target.left != null) {
            target = target.left;
        }
        //这时 target就指向了最小结点
        //删除最小结点
        delNode(target.value);
        return target.value;
    }

    public Node getRoot() {
        return root;
    }
}


class Node {

    int value;

    Node left;

    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void addNode(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left != null) {
                this.left.addNode(node);
            } else {
                this.left = node;
            }
        } else {
            if (this.right != null) {
                this.right.addNode(node);
            } else {
                this.right = node;
            }
        }
    }

    public void midOrderBinarySortTree() {
        if (this.left != null) {
            this.left.midOrderBinarySortTree();
        }
        System.out.println(this.toString());
        if (this.right != null) {
            this.right.midOrderBinarySortTree();
        }
    }

    public Node searchNode(int value) {

        if(value == this.value) { //找到就是该结点
            return this;
        } else if(value < this.value) {//如果查找的值小于当前结点，向左子树递归查找
            //如果左子结点为空
            if(this.left  == null) {
                return null;
            }
            return this.left.searchNode(value);
        } else { //如果查找的值不小于当前结点，向右子树递归查找
            if(this.right == null) {
                return null;
            }
            return this.right.searchNode(value);
        }
    }

    public Node searchParent(int value) {
        //如果当前结点就是要删除的结点的父结点，就返回
        if((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果查找的值小于当前结点的值, 并且当前结点的左子结点不为空
            if(value < this.value && this.left != null) {
                return this.left.searchParent(value); //向左子树递归查找
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value); //向右子树递归查找
            } else {
                return null; // 没有找到父结点
            }
        }

    }

}
