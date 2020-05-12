package com.company;

/***
 * ░░░░░░░░░░░░░░░░░░░░░░░░▄░░
 * ░░░░░░░░░▐█░░░░░░░░░░░▄▀▒▌░
 * ░░░░░░░░▐▀▒█░░░░░░░░▄▀▒▒▒▐
 * ░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐
 * ░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐
 * ░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌
 * ░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒
 * ░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐
 * ░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄
 * ░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒
 * ▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒
 * 单身狗就这样默默地看着你，一句话也不说。
 */

import java.util.Stack;

/**
 * @author ：lovelydragon
 * @date ：Created in 2019-03-18 12:57
 * @description：
 */
public class MinStack {

    Stack<Integer> stack;
    //新增一个栈，用来保存每个元素进栈时的最小值
    Stack<Integer> minStack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(x);
        if (x<min){
            minStack.push(x);
            min = x;
        }
        else
            minStack.push(min);

    }

    public void pop() {
        if (stack.size() == 0)
            return;
        stack.pop();
        minStack.pop();
        if (stack.size() == 0)
            min = Integer.MAX_VALUE;
        else
            min = minStack.peek();
    }

    public int top() {
        if (stack.size() == 0)
            return -1;
        return stack.peek();
    }

    public int getMin() {
        if (stack.size() == 0)
            return -1;
        return min;
    }
}
