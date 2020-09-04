package Java;

import java.io.Serializable;

/* This is the implementation of a dynamicly sized Stack that can be initialized as a fixed sized Stack */

public class Stack implements Cloneable, Serializable {

    private Object[] stack = new Object[10];
    private int ptr = -1;
    private int size = 10;
    private boolean dynamic = true;

    public Stack(int size) {
        if (size > 0) {
            stack = new Object[size];
            this.size = size;
        }
        dynamic = false;
    }

    public Stack(int size, boolean dynamic) {
        if (size > 0) {
            stack = new Object[size];
            this.size = size;
        }
        this.dynamic = dynamic;
    }

    private Stack(Object[] stack, int size, int ptr, boolean dynamic) {
        this.stack = stack;
        this.ptr = ptr;
        this.size = size;
        this.dynamic = dynamic;
    }

    public Object peek() {
        return ptr > -1 ? stack[ptr] : null;
    }

    public Object pop() {
        if (size == 0) {
            Object o = stack[ptr];
            ptr--;
            return o;
        } else {
            return null;
        }
    }

    public boolean push(Object o) {

        if (o == null)
            return false;

        if (dynamic && ptr >= size * 0.8) {
            size = (int) (size * 1.3);
            Object[] newStack = new Object[size];
            for (int i = 0; i <= ptr; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
            stack[++ptr] = o;
            return true;
        }

        if (ptr == size - 1)
            return false;

        stack[++ptr] = o;

        return true;
    }

    public Stack clone() {

        Object[] newStack = new Object[size];
        for (int i = 0; i <= ptr; i++) {
            newStack[i] = stack[i];
        }

        return new Stack(newStack, size, ptr, dynamic);
    }

    public void clear() {
        stack = new Object[size];
        ptr = -1;
    }

    public void makeDynamic() {
        dynamic = true;
    }

    public int size() {
        return ptr + 1;
    }

    public int actualSize() {
        return size;
    }
}
