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
            System.out.println("链表为空不能更新");
        }
        boolean updateTarget = false;
        while (updateNode != null) {
            if (updateNode.no == newHeroNode.no) {
                updateTarget = true;
                break;
            }
            updateNode = updateNode.next;
        }
        if (updateTarget) {
            updateNode.name = newHeroNode.name;
            updateNode.nickname = newHeroNode.nickname;
        } else {
            System.out.println("没找到要更新的节点!");
        }
    }

    public void delete(HeroNodeOfDouble node) {

        HeroNodeOfDouble deleteNode = headNode.next;
        if (deleteNode == null) {
            System.out.println("链表为空不能删除");
        }
        boolean target = false;
        while (true) {
            if (node.no == deleteNode.no) {
                target = true;
                break;
            }
            deleteNode = deleteNode.next;
            if (deleteNode == null) {
                break;
            }
        }
        if (target) {
            HeroNodeOfDouble temp = deleteNode;
            if (deleteNode.next == null) {
                deleteNode.pre.next = null;
            } else {
                deleteNode.pre.next = temp.next;
                deleteNode.next.pre = temp.pre;
            }
        } else {
            System.out.println("要删除的节点没找到！");
        }
    }
}
