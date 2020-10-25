package com.pl1111w.datastructures.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @title: pl1111w-栈结构
 * @description: 逆波兰表达式
 * @author: Kris
 * @date 2020/10/19 23:01
 */
public class PolandNotation {
    /**
     * 思路分析
     * 1、首先将输入的字符串类型的中序表达式进行逐项拆分存入List中
     * 2、建立两个栈（操作栈，结果栈【结果栈只有压栈操作可以用List代替】）
     * 3.1、遍历List,如果遇到数字，直接压入结果栈
     * 3.2、如果遇到操作符号，是左括号或者操作栈为空，直接入操作栈
     * 3.3、如果遇到右括号，弹出操作栈内所有元素直到遇到左括号为止
     * 3.4、如果操作符低于栈顶元素的优先级，操作栈栈顶元素出栈并压入结果栈
     * 将优先级低的操作符压入操作栈，否则直接将操作符压入操作栈
     * 3.5、将操作栈剩余的操作符出栈并压入结果栈
     * 4、逆波兰表达式计算规则（从左到右扫描，遇到数字压入栈，遇到操作符弹出
     * 栈顶两个数字，计算结果并将结果压入栈【注意除法跟减法顺序运算顺序】）
     **/

    public static void main(String[] args) {
        String expression = "10+((20/5)*5)-50";//注意表达式
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中序表达式进行逐项拆分存入List: " + infixExpressionList);
        List<String> resultList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("逆波兰表达式:" + resultList);
        int result = calculate(resultList);
        System.out.println("逆波兰表达式计算结果：" + result);

    }

    private static int calculate(List<String> resultList) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < resultList.size(); i++) {
            if (resultList.get(i).matches("\\d+")) {
                stack.push(Integer.parseInt(resultList.get(i)));
            } else {
                int number1 = stack.pop();
                int number2 = stack.pop();
                /**注意除法跟减法顺序！！！**/
                if (resultList.get(i).equals("+")) {
                    stack.push(number1 + number2);
                } else if (resultList.get(i).equals("-")) {
                    stack.push(number2 - number1);
                } else if (resultList.get(i).equals("*")) {
                    stack.push(number2 * number1);
                } else if (resultList.get(i).equals("/")) {
                    stack.push(number2 / number1);
                } else {
                    throw new RuntimeException("符号匹配错误！");
                }
            }

        }
        return stack.pop();
    }

    private static List<String> parseSuffixExpressionList(List<String> infixExpressionList) {

        Stack<String> operationStack = new Stack<>();
        //Stack<String> resultStack = new Stack<>();
        List<String> resultList = new ArrayList<>();

        for (String element : infixExpressionList) {
            if (element.matches("\\d+")) {
                resultList.add(element);
            } else if (element.equals("(") || operationStack.size() == 0) {
                operationStack.push(element);
            } else if (element.equals(")")) {
                while (!operationStack.peek().equals("(")) {
                    resultList.add(operationStack.pop());
                }
                //移除左括号
                operationStack.pop();
            } else {
                while (operationStack.size() != 0 && Operation.getValue(operationStack.peek()) > Operation.getValue(element)) {
                    resultList.add(operationStack.pop());
                }
                operationStack.push(element);
            }
        }
        while (operationStack.size() != 0) {
            resultList.add(operationStack.pop());
        }
        return resultList;
    }

    private static List<String> toInfixExpressionList(String expression) {

        List<String> stringList = new ArrayList<>();
        int length = expression.length();
        String str = "";
        int i = 0;
        do {
            char c;
            if ((c = expression.charAt(i)) < 48 || (c = expression.charAt(i)) > 57) {
                str = str + c;
                stringList.add(str);
                str = "";
                i++;
            } else {
                /**一定要判断字符串是否越界！！！**/
                while (i < expression.length() && (c = expression.charAt(i)) > 47 && (expression.charAt(i)) < 57) {
                    str = str + c;
                    i++;
                }
                stringList.add(str);
                str = "";
            }
        } while (length > i);
        return stringList;
    }

}

class Operation {

    public static int getValue(String value) {
        switch (value) {
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            default:
                return 0;
        }

    }
}
