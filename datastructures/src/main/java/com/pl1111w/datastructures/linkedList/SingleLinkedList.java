package com.pl1111w.datastructures.linkedList;

import lombok.Data;

/**
 * @title: pl1111w
 * @description: 链表main方法
 * @author: Kris
 * @date 2020/9/26 11:16
 */
@Data
public class SingleLinkedList {

    public static void main(String[] args) {

        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode node5 = new HeroNode(5, "华容", "小李广");

        ParentHeroNode parentHeroNode = new ParentHeroNode();
//        parentHeroNode.addNode(node2);
//        parentHeroNode.addNode(node1);
//        parentHeroNode.addNode(node3);
//        parentHeroNode.addNode(node4);
//        System.out.println(parentHeroNode.toString());

        parentHeroNode.addNodeByOrder(node2);
        parentHeroNode.addNodeByOrder(node1);
        parentHeroNode.addNodeByOrder(node3);
        parentHeroNode.addNodeByOrder(node4);

        System.out.println("顺序添加： " + parentHeroNode.toString());
        System.out.println("逆序打印："+parentHeroNode.InversePrintHeroNode(parentHeroNode.getHeadNode()));
        System.out.println("链表翻转: "+parentHeroNode.reversetHeroNode(parentHeroNode.getHeadNode()));
        node4.setNickName("林教头");
        parentHeroNode.updateNode(node4);
        parentHeroNode.updateNode(node5);

        System.out.println("链表长度：" + parentHeroNode.heroNodeOfLength());
        System.out.println("searchLastOfIndex：" + parentHeroNode.searchLastOfIndex(3));


        parentHeroNode.deleteNode(node4.getNo());
        System.out.println(("删除一个节点： " + parentHeroNode.toString()));
    }

}
