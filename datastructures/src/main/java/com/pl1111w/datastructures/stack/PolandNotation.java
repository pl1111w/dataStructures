package com.pl1111w.datastructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @title: pl1111w
 * @description: TODO
 * @author: Kris
 * @date 2020/10/19 23:01
 */
public class PolandNotation {

    public static void main(String[] args) {

//        String expression = "30 4 + 5 * 6 -";
//        int value = calculate(expression);
//        System.out.println(value);

        String expression = "1+((2+3)*4)-5";//注意表达式
        List<String> infixExpressionList = toInfixExpressionList(expression);
        List<String> suffixExpreesionList = parseSuffixExpreesionList(infixExpressionList);
        System.out.println(suffixExpreesionList.toString());
        int value = calculate(suffixExpreesionList);
        System.out.println(value);
    }

    private static List<String> parseSuffixExpreesionList(List<String> infixExpressionList) {
        Stack<String> operation = new Stack<>();
        //Stack<String> result = new Stack<>();
        List<String> resultList = new ArrayList<>();
        for (String item : infixExpressionList) {
            if (item.matches("\\d+")) {
                resultList.add(item);
            } else if (item.equals("(") || operation.size() == 0) {
                operation.push(item);
            } else if (item.equals(")")) {
                while (!operation.peek().equals("(")) {
                    resultList.add(operation.pop());
                }
                operation.pop();
            } else {
                while (operation.size() != 0 && Operation.getValue(operation.peek()) >= Operation.getValue(item)) {
                    resultList.add(operation.pop());
                }
                operation.push(item);
            }
        }
        while (operation.size()!=0){
            resultList.add(operation.pop());
        }

        return resultList;
    }

    private static List<String> toInfixExpressionList(String expression) {

        List<String> stringList = new ArrayList<>();
        int length = expression.length();
        String str;
        int i = 0;
        do {
            char c;
            if ((c = expression.charAt(i)) < 48 || (c = expression.charAt(i)) > 57) {
                stringList.add("" + c);
                i++;
            } else {
                str = "";
                while (i < expression.length() && (c = expression.charAt(i)) > 48 && (c = expression.charAt(i)) < 57) {
                    str += c;
                    i++;
                }
                stringList.add(str);
            }
        } while (i < expression.length());
        return stringList;
    }
    public static int calculate(List<String> ls) {
        // 创建给栈, 只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        // 遍历 ls
        for (String item : ls) {
            // 这里使用正则表达式来取出数
            if (item.matches("\\d+")) { // 匹配的是多位数
                // 入栈
                stack.push(item);
            } else {
                // pop出两个数，并运算， 再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res 入栈
                stack.push("" + res);
            }

        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }
    private static int calculate(String expression) {
        String strs[] = expression.split(" ");
        List<String> list = new ArrayList<>();
        for (String str : strs) {
            list.add(str);
        }
        Stack<String> stringStack = new Stack<>();
        for (String element : list) {
            if (element.matches("\\d+")) {
                stringStack.push(element);
            } else {
                int num1 = Integer.parseInt(stringStack.pop());
                int num2 = Integer.parseInt(stringStack.pop());
                int result = 0;
                if (element.equals("+")) {
                    result = num2 + num1;
                } else if (element.equals("-")) {
                    result = num2 - num1;
                } else if (element.equals("*")) {
                    result = num2 * num1;
                } else if (element.equals("/")) {
                    result = num2 / num1;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stringStack.push("" + result);
            }
        }
        return Integer.parseInt(stringStack.pop());
    }

}
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int value = 0;
        switch (operation) {
            case "+":
                value = ADD;
                break;
            case "-":
                value = SUB;
                break;
            case "*":
                value = MUL;
                break;
            case "/":
                value = DIV;
                break;
            default:
                System.out.println("无符号！");
        }
        return value;
    }
}
