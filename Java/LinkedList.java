package Java;

/* This is the implementation of a Singly LinkedList */
public class LinkedList {

    private class node {
        Object o;
        private node next;

        public node(Object o) {
            this.o = o;
            next = null;
        }
    }

    private node first = null;
    private int size = 0;

    public void add(Object o) {
        if (first == null) {
            first = new node(o);
        } else {

            node curr = first;

            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = new node(o);

        }
        size++;
    }

    public void add(int index, Object o) {
        if (size <= index) {
            return;
        }

        node curr = first;
        node next;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        next = curr.next;
        curr = new node(o);
        curr.next = next;
        size++;
    }

    public void addFirst(Object o) {
        node temp = first;
        first = new node(o);
        first.next = temp;
        size++;
    }

    public Object get(int index) {
        if (size == 0) {
            return null;
        }
        if (size <= index) {
            return null;
        }
        node curr = first;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.o;
    }

    public Object getFirst() {
        if (size == 0)
            return null;
        return first.o;
    }

    public Object getLast() {
        node curr = first;

        for (int i = 0; i < size; i++) {
            curr = curr.next;
        }

        return curr.o;
    }

    public int indexOf(Object o) {
        node curr = first;
        for (int i = 0; i < size; i++) {
            if (curr.equals(o))
                return i;
            curr = curr.next;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        node curr = first;
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (curr.equals(o))
                count = i;
            curr = curr.next;
        }
        return count;
    }

    public void remove(int index) {
        if (size <= index || first == null) {
            return;
        }

        node curr = first;
        node prev = null;
        for (int i = 0; i < size - 1; i++) {
            prev = curr;
            curr = curr.next;
        }

        if (prev == null)
            first = first.next;
        else if (curr.next == null)
            curr = null;
        else
            prev.next = curr.next;

        size--;
    }

    public int size() {
        return size;
    }

}
