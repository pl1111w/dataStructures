package com.pl1111w.datastructures.linkedList;

/**
 * @title: pl1111w
 * @description: TODO
 * @author: Kris
 * @date 2020/10/12 21:58
 */
public class HeroNodeOfDouble {

    public int no;

    public String name;

    public String nickname;

    public HeroNodeOfDouble next;

    public HeroNodeOfDouble pre;

    public HeroNodeOfDouble(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}
