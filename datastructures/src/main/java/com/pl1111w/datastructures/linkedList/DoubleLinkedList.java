package com.pl1111w.datastructures.linkedList;

/**
 * @title: pl1111w
 * @description: TODO
 * @author: Kris
 * @date 2020/10/12 21:57
 */
public class DoubleLinkedList {

    public static void main(String[] args) {
        HeroNodeOfDouble node1 = new HeroNodeOfDouble(1, "宋江", "及时雨");
        HeroNodeOfDouble node3 = new HeroNodeOfDouble(3, "吴用", "智多星");
        HeroNodeOfDouble node2 = new HeroNodeOfDouble(2, "卢俊义", "玉麒麟");
        HeroNodeOfDouble node4 = new HeroNodeOfDouble(3, "林冲", "豹子头");
        HeroNodeOfDouble node5 = new HeroNodeOfDouble(5, "华容", "小李广");

        ParentHeroNodeOfDouble parentHeroNodeOfDouble = new ParentHeroNodeOfDouble();
        parentHeroNodeOfDouble.addNode(node1);
        parentHeroNodeOfDouble.addNode(node2);
        parentHeroNodeOfDouble.addNode(node3);
        parentHeroNodeOfDouble.list();
        System.out.println("==========update=============");
        parentHeroNodeOfDouble.update(node3);
        parentHeroNodeOfDouble.list();
        System.out.println("==========delete=============");
        parentHeroNodeOfDouble.delete(node5);
        parentHeroNodeOfDouble.list();


    }
}
