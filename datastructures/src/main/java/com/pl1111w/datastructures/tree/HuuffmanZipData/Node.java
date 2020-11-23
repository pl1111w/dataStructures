package com.pl1111w.datastructures.tree.HuuffmanZipData;

import lombok.Data;

@Data
public class Node implements Comparable<Node> {

    //次数
    int weight;

    //字符
    Byte data;

    Node left;

    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return o.weight - this.weight;
    }
}
