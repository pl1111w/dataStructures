package com.pl1111w.datastructures.queue;

/**
 * @title: pl1111w
 * @description: 数组（可复用）模拟队列
 * @author: Kris
 * @date 2020/9/26 11:14
 */
public class ArrayQueueCycle {

    private int maxSize;

    private int front;

    private int rear;

    private int arr[];

    public ArrayQueueCycle(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;//数组最后一个位置
    }

    public static void main(String[] args) {
        ArrayQueueCycle queueCycle = new ArrayQueueCycle(6);
        queueCycle.add(1);
        queueCycle.add(2);
        queueCycle.add(3);
        queueCycle.add(4);
        queueCycle.add(5);
        queueCycle.remove();
        queueCycle.remove();
        queueCycle.remove();
        queueCycle.remove();
        queueCycle.add(6);
        queueCycle.add(7);
        queueCycle.add(8);
        queueCycle.add(9);
        queueCycle.showQueue();
    }

    private void add(int i) {

        if (isFull()) {
            throw new RuntimeException("队列已满");
        } else {
            System.out.println("add:" + i);
            arr[rear % maxSize] = i;
            rear = (rear + 1) % maxSize;
        }
    }

    private void remove() {

        if (isEmpty()) {
            throw new RuntimeException("队列空");
        } else {
            System.out.println("remove:" + arr[front % maxSize]);
            front = (front + 1) % maxSize;
        }
    }


    private boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    private boolean isEmpty() {
        return rear == front;
    }

    public void showQueue() {
        for (int i = front; i < front + size(); i++) {
            System.out.println("【" + arr[i % maxSize] + "】");
        }
        System.out.println(rear);
        System.out.println(front);
    }

    private int size() {

        return (rear + maxSize - front) % maxSize;
    }
}

