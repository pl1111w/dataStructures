package com.pl1111w.datastructures.linkedList;

import lombok.Data;

/**
 * @title: pl1111w
 * @description: TODO
 * @author: Kris
 * @date 2020/10/12 22:01
 */
@Data
public class ParentHeroNodeOfDouble {

    private HeroNodeOfDouble headNode = new HeroNodeOfDouble(0, "", "");

    public void addNode(HeroNodeOfDouble node) {
        HeroNodeOfDouble temp = headNode;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    public void list() {
        if (headNode.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNodeOfDouble heroNodeOfDouble = headNode.next;
        while (true) {
            if (heroNodeOfDouble == null) {
                break;
            }
            System.out.println(heroNodeOfDouble);
            heroNodeOfDouble = heroNodeOfDouble.next;
        }
    }

    public void update(HeroNodeOfDouble newHeroNode) {
        HeroNodeOfDouble updateNode = headNode.next;
        if (updateNode == null) {
            System.out.println("链表为空");
        }
        boolean flag = false; // 表示是否找到该节点
        while (true) {
            if (updateNode.no == newHeroNode.no) {
                flag = true;
                break;
            }
            if (updateNode == null) {
                break;
            }
            updateNode = updateNode.next;
        }
        if (flag) {
            updateNode.name = newHeroNode.name;
            updateNode.nickname = newHeroNode.nickname;
        } else {
            System.out.println("没找到！");
        }
    }
}
