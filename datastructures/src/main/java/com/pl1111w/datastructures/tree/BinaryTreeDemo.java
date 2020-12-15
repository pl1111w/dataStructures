package com.pl1111w.datastructures.tree;

/**
 * @title: pl1111w
 * @description: 二叉树遍历与搜索
 * @author: Kris
 * @date 2020/11/15 11:22
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        //先需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);
        binaryTree.setRoot(root);
//        binaryTree.preOrder();
//        binaryTree.midOrder();
//        binaryTree.afterOrder();
//        binaryTree.middleSearch(4);
//        binaryTree.preSearch(4);

        binaryTree.removeNode(5);
        binaryTree.preOrder();

    }


}

class HeroNode {

    private int id;
    private String name;

    private HeroNode left;
    private HeroNode right;

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void preOrder() {
        System.out.println(this); //先输出父结点
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void midOrder() {
        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this); //先输出父结点
        //递归向右子树中序遍历
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    public void afterOrder() {

        if (this.left != null) {
            this.left.afterOrder();
        }
        if (this.right != null) {
            this.right.afterOrder();
        }
        System.out.println(this);
    }

    public HeroNode middleSearch(int no) {

        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.middleSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.id == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.middleSearch(no);
        }
        return resNode;
    }

    public HeroNode preSearch(int no) {
        if (this.id == no) {
            return this;
        }
        HeroNode heroNode = null;
        //左递归
        if (this.left != null) {
            heroNode = this.left.preSearch(no);
        }
        //找到了
        if (heroNode != null) {
            return heroNode;
        }
        //右递归
        if (this.right != null) {
            heroNode = this.right.preSearch(no);
        }
        return heroNode;
    }

    public HeroNode afterSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.afterSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.afterSearch(no);
        }
        if (this.id == no) {
            return this;
        }
        return resNode;
    }

    public boolean removeNode(int no) {
        boolean target = false;
        if (this.left != null) {
            if (this.left.id == no) {
                this.left = null;
                return true;
            } else {
                target = this.left.removeNode(no);
            }
        }
        if (this.right != null) {
            if (this.right.id == no) {
                this.right = null;
                return true;
            } else {
                target = this.right.removeNode(no);
            }
        }
        return target;
    }
}

class BinaryTree {

    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void afterOrder() {
        if (this.root != null) {
            this.root.afterOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public HeroNode middleSearch(int i) {
        HeroNode heroNode = null;
        if (this.root != null) {
            heroNode = this.root.middleSearch(i);
            System.out.println(heroNode.toString());
        } else {
            System.out.println("middleSearch not fund id=" + i);
        }
        return heroNode;
    }

    public HeroNode preSearch(int i) {
        HeroNode heroNode = null;
        if (this.root != null) {
            heroNode = this.root.preSearch(i);
            System.out.println("preSearch:" + heroNode.toString());
        } else {
            System.out.println("preSearch not fund id=" + i);
        }
        return heroNode;
    }

    public HeroNode afterSearch(int i) {
        HeroNode heroNode = null;
        if (this.root != null) {
            heroNode = this.root.afterSearch(i);
            System.out.println("afterSearch:" + heroNode.toString());
        } else {
            System.out.println("afterSearch not fund id=" + i);
        }
        return heroNode;
    }

    public void removeNode(int i) {
        if (this.root != null) {
            if (this.root.getId() == i) {
                this.root = null;
            } else {
                boolean result = this.root.removeNode(i);
                System.out.println("removed:" + result);
            }
        } else {
            System.out.println("remove failed");
        }

    }
}
