package com.pl1111w.datastructures.linkedList;

import lombok.Data;

@Data
public class ParentHeroNode {

    private HeroNode headNode=new HeroNode(0,"","");

    public void addNode(HeroNode node) {
        HeroNode temp = this.headNode;
        while (true) {
            if(temp.getNext()==null){
                break;
            }
            temp=temp.getNext();
        }
        temp.setNext(node);

    }
}
