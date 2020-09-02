package Java;

public class Stack {

    private Object[] stack;
    private int ptr = -1;
    private int size;
    boolean dynamic = true;

    public Stack() {
        stack = new Object[10];
        size = 10;
    }

    public Stack(int size, boolean dynamic) {
        stack = new Object[size];
        this.size = size;
        dynamic = false;
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

    public int size() {
        return ptr + 1;
    }

    public int actualSize() {
        return size;
    }
}
