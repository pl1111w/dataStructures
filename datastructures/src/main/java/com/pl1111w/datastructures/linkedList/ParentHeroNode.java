package com.pl1111w.datastructures.linkedList;

import lombok.Data;

@Data
public class ParentHeroNode {

    private HeroNode headNode = new HeroNode(0, "", "");

    public void addNode(HeroNode node) {
        HeroNode temp = this.headNode;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(node);

    }

    public void addNodeByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = headNode;
        boolean flag = false; // flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() > heroNode.getNo()) {
                break;
            } else if (temp.getNext().getNo() == heroNode.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.getNo());
        } else {
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
    }
}
