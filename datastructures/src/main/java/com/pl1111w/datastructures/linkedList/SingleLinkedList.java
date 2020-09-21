package com.pl1111w.datastructures.linkedList;

import lombok.Data;

@Data
public class SingleLinkedList {

    public static void main(String[] args) {

        ParentHeroNode parentHeroNode = new ParentHeroNode(new HeroNode(0,"",""));
        HeroNode node1= new HeroNode(1,"宋江","及时雨");
        HeroNode node2= new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode node3= new HeroNode(3,"吴用","智多星");
        parentHeroNode.addNode(node1);
        parentHeroNode.addNode(node2);
        parentHeroNode.addNode(node3);
        System.out.println(parentHeroNode.toString());
    }

}
