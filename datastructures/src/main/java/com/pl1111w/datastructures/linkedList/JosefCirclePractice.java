package com.pl1111w.datastructures.linkedList;

/**
 * @title: pl1111w
 * @description: 约瑟夫复习
 * @author: Kris
 * @date 2020/12/28 23:18
 */
public class JosefCirclePractice {

    private JosefBoy firstBoy = new JosefBoy(0);


    public void add(int number) {
        if (number < 1) {
            System.out.println("没有小孩儿");
        }
        JosefBoy head = firstBoy;
        for (int i = 1; i < number; i++) {
            JosefBoy josefBoy = new JosefBoy(i);
            head.setNext(josefBoy);
            josefBoy.setNext(firstBoy);
            head = head.getNext();
        }
    }

    public void show() {
        JosefBoy josefBoy = firstBoy;
        System.out.println(josefBoy.getNo());
        if (josefBoy.getNext() != null) {
            while (josefBoy.getNext() != firstBoy) {
                josefBoy = josefBoy.getNext();
                System.out.println(josefBoy.getNo());
            }
        }
    }

    public void countBoy(int begin, int count, int total) {

        JosefBoy josefBoy = firstBoy;
        JosefBoy beforeBoy = firstBoy;
        if (josefBoy.getNext() != null) {
            while (beforeBoy.getNext() != josefBoy) {
                beforeBoy = beforeBoy.getNext();
            }
        }
        for (int i = 0; i < begin - 1; i++) {
            beforeBoy = beforeBoy.getNext();
            josefBoy = josefBoy.getNext();
        }

        while (true) {
            if (beforeBoy == firstBoy) {
                break;
            }
            for (int j = 0; j < count - 1; j++) {
                firstBoy = firstBoy.getNext();
                beforeBoy = beforeBoy.getNext();
            }
            System.out.printf("小孩%d出圈\n", firstBoy.getNo());
            beforeBoy.setNext(firstBoy.getNext());
            firstBoy = firstBoy.getNext();
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", firstBoy.getNo());
    }
}
