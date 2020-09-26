package com.pl1111w.datastructures.queue;

/**
 * @title: pl1111w
 * @description: 数组（不可复用）模拟队列
 * @author: Kris
 * @date 2020/9/26 11:16
 */
public class ArrayQueue {

    private int maxSize;

    private int front;

    private int rear;

    private int arr[];

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否满
    public boolean isEmpty() {
        return front == rear;
    }

    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.remove();
        queue.remove();
        queue.showQueue();
    }

    private void add(int i) {

        if (isFull()) {
            System.out.println("队列满了");
        } else {
            rear++;
            arr[rear] = i;
        }

    }

    private int remove() {

        if (isEmpty()) {
            throw new RuntimeException("队列空了");
        }
        front++;
        return arr[front];

    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空");
        }
        for (int i = front; i < rear - front; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

}

