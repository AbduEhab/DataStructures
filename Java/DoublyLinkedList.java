package Java;

/* This is the implementation of a Doubly LinkedList */
public class DoublyLinkedList {

    private class node {
        Object o;
        private node next;
        private node previous;

        public node(Object o) {
            this.o = o;
            next = null;
            previous = null;
        }
    }

    private node first = null;
    private int size = 0;

    public void add(Object o) {
        if (first == null) {
            first = new node(o);
        } else {

            node curr = first;
            node prev = null;

            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }

            curr.next = new node(o);
            curr.next.previous = prev;

        }
        size++;
    }

    public void add(int index, Object o) {
        if (size <= index) {
            return;
        }

        node curr = first;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        curr.o = o;
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
        for (int i = 0; i < size - 1; i++) {
            curr = curr.next;
        }

        if (curr.previous == null) {
            first = first.next;
            first.previous = null;

        } else if (curr.next == null)
            curr.previous.next = null;

        else {

            curr.previous.next = curr.next;
            curr.next.previous = curr.previous;
        }

        size--;
    }

    public int size() {
        return size;
    }

}
