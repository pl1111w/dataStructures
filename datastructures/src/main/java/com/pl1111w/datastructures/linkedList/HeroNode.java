package com.pl1111w.datastructures.linkedList;

import lombok.Data;

@Data
public class HeroNode {

    private int no;

    private String name;

    private String nickName;

    private HeroNode next;

    public HeroNode(int no,String name,String nickName){
        this.no=no;
        this.name=name;
        this.nickName=nickName;
    }
}
