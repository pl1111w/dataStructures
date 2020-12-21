package com.pl1111w.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: TODO
 * @author: Kris
 * @date 2020/12/21 23:13
 */
public class GraphPractice {

    private ArrayList<String> vertexList;//存储顶点集合

    private int[][] edges;//存储邻接矩阵

    private int numOfEdges;//表示边的数目

    //定义给数组boolean[], 记录某个结点是否被访问
    private boolean[] isVisited;

    public GraphPractice(int n) {
        this.edges = new int[n][n];
        this.isVisited = new boolean[n];
        this.numOfEdges = 0;
        this.vertexList = new ArrayList<>(n);
    }

    public static void main(String[] args) {

        int n = 8;  //结点的个数

        String vertexes[] = {"1", "2", "3", "4", "5", "6", "7", "8"};

        GraphPractice graph = new GraphPractice(n);

        for (String vertex : vertexes) {
            graph.insertVertex(vertex);
        }

        //更新边的关系
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);


        //显示一把邻结矩阵
        graph.showGraph();
        graph.dfs();
    }

    private void dfs() {
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    private void dfs(boolean[] isVisited, int i) {
        System.out.println(getValueByIndex(i) + "->");

        isVisited[i] = true;
        //查找结点i的第一个邻接结点w
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //w被访问过
            w = getNextNeighbor(i, w);
        }
    }

    private int getNextNeighbor(int i, int w) {
        for (int j = w + 1; j < edges[i].length; j++) {
            if (edges[i][j] == 1) {
                return j;
            }
        }
        return -1;
    }

    private int getFirstNeighbor(int i) {
        for (int j = 0; j < edges[i].length; j++) {
            if (edges[i][j] == 1) {
                return j;
            }
        }
        return -1;
    }

    //返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    private void showGraph() {
        for (int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }

    private void insertEdge(int i, int j, int val) {
        edges[i][j] = val;
        edges[j][i] = val;
    }


    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }
}
