package com.ericzhang.quiz.s1;

import java.util.Stack;

/**
 * @author Eric Zhang
 * @version 1.0
 */

public class TenStack {

    private int[] elements;
    private int size;

    public TenStack() {
        elements = new int[10];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(int element) {
        elements[size] = element;
        size++;
    }

    public int pop() {
        int top = peek();
        elements[size - 1] = 0;
        size--;
        return top;
    }

    public int peek() {
        return elements[size - 1];
    }
}
