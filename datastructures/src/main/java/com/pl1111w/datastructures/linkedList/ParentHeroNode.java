package com.pl1111w.datastructures.linkedList;

import lombok.Data;

@Data
public class ParentHeroNode {

    private HeroNode headNode;

    public ParentHeroNode(HeroNode headNode) {
        this.headNode = headNode;
    }

    public void addNode(HeroNode headNode) {
        while (true) {
            if (this.headNode.getNext() == null) {
                this.headNode.setNext(headNode);
                break;
            } else {
                this.headNode = this.headNode.getNext();
            }
        }
    }
}
