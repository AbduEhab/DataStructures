package Java;

import java.io.Serializable;

/* This is the implementation of a Queue */

public class Queue implements Cloneable, Serializable {

    private Object[] queueObjects = new Object[10];
    private int size = 0;
    private int actualSize = 10;
    private boolean dynamic = false;

    public Queue(int actualSize, boolean dynamic) {
        if (actualSize > 0) {
            queueObjects = new Object[actualSize];
            this.actualSize = actualSize;
        }
        this.dynamic = dynamic;
    }

    public Queue(Object[] newQeueu, int size, boolean dynamic) {
        this.queueObjects = newQeueu;
        this.size = size;
        this.dynamic = dynamic;
    }

    public boolean add(Object o) {
        if (o == null) {
            return false;
        }
        if (dynamic && size > actualSize * 0.8) {
            size = (int) (size * 1.3);
            Object[] newQueue = new Object[size];
            for (int i = 0; i <= actualSize * 0.8; i++) {
                newQueue[i] = queueObjects[i];
            }
            queueObjects = newQueue;
            queueObjects[size++] = o;
            return true;
        }

        if (actualSize == size) {
            return false;
        }

        queueObjects[size++] = o;
        return true;
    }

    public boolean push(Object o) {
        return add(o);
    }

    public boolean offer(Object o) {
        return add(o);
    }

    public Object peek() {
        return size != 0 ? queueObjects[0] : null;
    }

    public Object poll() {
        if (size == 0)
            return null;

        Object val = queueObjects[0];

        for (int i = 1; i < size; i++) {
            queueObjects[i - 1] = queueObjects[i];
        }

        size--;

        return val;
    }

    public Object pull() {
        return poll();
    }

    public Object remove() {
        Object val = queueObjects[0];

        for (int i = 1; i < size; i++) {
            queueObjects[i - 1] = queueObjects[i];
        }

        size--;

        return val;
    }

    public Queue clone() {
        Object[] newQeueu = new Object[size];
        for (int i = 0; i <= size; i++) {
            newQeueu[i] = queueObjects[i];
        }

        return new Queue(newQeueu, size, dynamic);
    }

}
