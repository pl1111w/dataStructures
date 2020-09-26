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
        ArrayQueueCycle queueCycle = new ArrayQueueCycle(5);
        queueCycle.add(1);
        queueCycle.add(2);
        queueCycle.add(3);
        queueCycle.add(4);
        queueCycle.add(5);
        queueCycle.remove();
        queueCycle.remove();
        queueCycle.remove();
        queueCycle.add(4);
        queueCycle.add(5);
        queueCycle.remove();
        queueCycle.showQueue();
    }

    private void add(int i) {

        if (isFull()) {
            System.out.println("队列已满");
        } else {
            System.out.println("add:" + i);
            arr[rear % maxSize] = i;
            rear++;
        }
    }

    private void remove() {

        if (isEmpty()) {
            System.out.println("队列空");
        } else {
            System.out.println("remove:" + arr[front]);
            front = (front + 1) % maxSize;
        }
    }


    private boolean isFull() {
        if (front == 0) {
            return false;
        } else {
            return rear % maxSize == front;
        }

    }

    private boolean isEmpty() {
        return rear == front;
    }

    public void showQueue() {
        for (int i = front; i < front + size(); i++) {
            System.out.println(arr[i % maxSize]);
        }
    }

    private int size() {
        if (front < rear) {
            return rear - front;
        }
        return (rear + maxSize - front) % maxSize;
    }
}

