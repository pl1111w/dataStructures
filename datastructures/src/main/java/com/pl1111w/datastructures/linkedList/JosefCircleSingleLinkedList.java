package com.pl1111w.datastructures.linkedList;

/**
 * @title: pl1111w
 * @description: TODO
 * @author: Kris
 * @date 2020/10/17 8:08
 */
public class JosefCircleSingleLinkedList {

    JosefBoy firstBoy = new JosefBoy(0);


    public void add(int number) {
        if (number < 1) {
            System.out.println("没有小孩儿");
        }
        JosefBoy headBoy = firstBoy;
        for (int i = 1; i < number; i++) {
            JosefBoy josefBoy = new JosefBoy(i);
            headBoy.setNext(josefBoy);
            josefBoy.setNext(firstBoy);
            headBoy = headBoy.getNext();
        }
    }

    public void list() {
        JosefBoy headBoy = firstBoy;
        System.out.println("Boy: " + headBoy.getNo());
        while (headBoy.getNext() != null) {
            if (headBoy.getNext() == firstBoy) {
                break;
            } else {
                headBoy = headBoy.getNext();
                System.out.println("Boy: " + headBoy.getNo());
            }

        }
    }

    public void countBoy(int startNo, int countNum, int nums) {
        if (firstBoy == null || countNum > nums || startNo < 0) {
            System.out.println("参数有误");
            return;
        }
        JosefBoy helper = firstBoy;
        while (true) {
            if (helper.getNext() == firstBoy) {
                break;
            }
            helper = helper.getNext();
        }
//        while (true) {
//            if (startNo == firstBoy.getNo()) {
//                break;
//            }
//            firstBoy = firstBoy.getNext();
//            helper = helper.getNext();
//        }
        for (int j = 0; j < startNo - 1; j++) {
            firstBoy = firstBoy.getNext();
            helper = helper.getNext();
        }


        while (true) {
            if (helper == firstBoy) {
                break;
            }
            for (int j = 0; j < countNum - 1; j++) {
                firstBoy = firstBoy.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n", firstBoy.getNo());
            helper.setNext(firstBoy.getNext());
            firstBoy = firstBoy.getNext();
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", firstBoy.getNo());
    }
}