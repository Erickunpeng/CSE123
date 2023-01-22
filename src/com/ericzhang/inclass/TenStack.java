package com.ericzhang.inclass;

import java.util.NoSuchElementException;

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

    public void push(int element) {
        if (size == 10) {
            throw new IllegalStateException();
        }
        elements[size] = element;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        size--;
        return elements[size];
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
