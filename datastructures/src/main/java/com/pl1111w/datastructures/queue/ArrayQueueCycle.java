package com.pl1111w.datastructures.queue;

/**
 * @title: pl1111w
 * @description: 数组（可复用）模拟队列
 * @author: Kris
 * @date 2020/9/26 11:14
 */
public class ArrayQueueCycle {

    /**思路分析
     * 1、在添加一个元素前，首先判断队列是否已经满了
     * 每次添加一个元素时，rear下标+1 保证队列可以循环，则
     * rear+1必须《=maxSize，当超过maxSize则要做取余操作
     * 当(rear+1)%=maxSize时候，队列满了（队列实际只能存放maxSize-1个元素）
     * 2、在删除一个元素时，首先判断队列是否已经空了
     * 判断条件为rear==front,没有空则front=(front+1)%maxSize
     * 3、进行遍历数组时候，从front开始到rear结束，由于rear可能小于front
     * front往后遍历个数为：(rear+maxSize-front)%maxSize
     * 输入数组下标也应该对maxSize取余
     * **/

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
    }

    private int size() {

        return (rear + maxSize - front) % maxSize;
    }
}

