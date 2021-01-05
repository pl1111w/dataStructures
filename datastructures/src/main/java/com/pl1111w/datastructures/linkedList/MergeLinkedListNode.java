package com.pl1111w.datastructures.linkedList;

/**
 * @title: pl1111w
 * @description: 合并两个链表
 * @author: Kris
 * @date 2021/1/5 22:24
 */
public class MergeLinkedListNode {

    public static void main(String[] args) {

        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode node5 = new HeroNode(5, "华容", "小李广");
        HeroNode node6 = new HeroNode(6, "公孙胜", "入云龙");
        node2.setNext(node4);
        node4.setNext(node6);
        node1.setNext(node3);
        node3.setNext(node5);
        HeroNode merged = mergeLinkedListNode(node1, node2);
        System.out.println(merged);

    }

    private static HeroNode mergeLinkedListNode(HeroNode node1, HeroNode node2) {
        HeroNode node = new HeroNode(0, "", "");
        HeroNode temp = node;
        while (node1 != null && node2 != null) {
            if (node1.getNo() <= node2.getNo()) {
                temp.setNext(node1);
                node1 = node1.getNext();
                temp=temp.getNext();
            } else {
                temp.setNext(node2);
                node2 = node2.getNext();
                temp=temp.getNext();
            }
        }
        temp.setNext(node1 == null ? node2 : node1);

        return node.getNext();
    }
}
