package com.pl1111w.datastructures.linkedList;

import lombok.Data;
/**
 * @title: pl1111w
 * @description: 链表类
 * @author: Kris
 * @date 2020/9/26 11:16
 */
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
