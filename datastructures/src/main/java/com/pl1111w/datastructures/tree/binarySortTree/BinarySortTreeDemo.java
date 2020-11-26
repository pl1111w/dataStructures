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
        binarySortTree.delNode(1);
        binarySortTree.delNode(2);
        binarySortTree.delNode(5);
        binarySortTree.delNode(10);
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
            return root.parentNode(value);
        }
    }

    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            Node target = searchNode(value);
            if (target == null) {
                return;
            }
            //二叉树只有一个节点
            if (root.right == null && root.left == null) {
                root = null;
                return;
            }
            Node parent = parentNode(value);

            //删除的是子节点
            if (target.left == null && target.right == null) {
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (target.right != null && target.left != null) {
                if (parent.left != null && parent.left.value == value) {
                    Node node = target.right;
                    while (node.left != null) {
                        node = node.left;
                    }
                    node.left = parent.left.left;
                    parent.left = node;
                } else if (parent.right != null && parent.right.value == value) {
                    if (parent.right != null && parent.right.value == value) {
                        Node node = target.left;
                        while (node.right != null) {
                            node = node.right;
                        }
                        node.right = parent.right.right;
                        parent.right = node;
                    }
                }
            } else {
                if (target.left != null && parent.left.value == value) {
                    parent.left = target.left;
                } else if (target.left != null && parent.right.value == value) {
                    parent.right = target.left;
                } else if (target.right != null && parent.left.value == value) {
                    parent.left = target.right;
                } else if (target.right != null && parent.right.value == value) {
                    parent.right = target.right;
                }
            }
        }
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

        if (this.value == value) {
            return this;
        } else if (this.value < value) {
            if (this.right != null) {
                return this.right.searchNode(value);
            } else {
                return null;
            }
        } else {
            if (this.left != null) {
                return this.left.searchNode(value);
            } else {
                return null;
            }
        }
    }

    public Node parentNode(int value) {

        if ((this.left != null && this.left.value == value)
                || this.right != null && this.right.value == value) {
            return this;
        }
        if(value < this.value && this.left != null) {
            return this.left.parentNode(value); //向左子树递归查找
        } else if (value >= this.value && this.right != null) {
            return this.right.parentNode(value); //向右子树递归查找
        } else {
            return null; // 没有找到父结点
        }
    }

}
