package Java;

/* This is the implementation of a Queue */

public class PriorityQueue {

    private Comparable[] queueObjects = new Comparable[10];
    private int size = 0;
    private int actualSize = 10;
    private boolean dynamic = false;

    public PriorityQueue(int actualSize, boolean dynamic) {
        if (actualSize > 0) {
            queueObjects = new Comparable[actualSize];
            this.actualSize = actualSize;
        }
        this.dynamic = dynamic;
    }

    public boolean add(Comparable key) {
        if (key == null) {
            return false;
        }
        if (dynamic && size > actualSize * 0.8) {
            size = (int) (size * 1.3);
            Comparable[] newQueue = new Comparable[size];
            for (int i = 0; i <= actualSize * 0.8; i++) {
                newQueue[i] = queueObjects[i];
            }
            queueObjects = newQueue;

            for (int i = 0; i < newQueue.length; i++) {
                if (queueObjects[i].compareTo(key) >= 0) {
                    shift(i); // still O(n) since the inner forloop happens once and then returns the method
                    queueObjects[i] = key;
                    size++;
                    return true;
                }
            }
        }
        if (actualSize == size) {
            return false;
        }
        queueObjects[size++] = key;
        return true;
    }

    private void shift(int index) {
        for (int i = size; i <= index; i--) {
            queueObjects[i - 1] = queueObjects[i];
        }
    }

    public boolean push(Comparable key) {
        return add(key);
    }

    public boolean offer(Comparable key) {
        return add(key);
    }

    public Comparable peek() {
        return size != 0 ? queueObjects[0] : null;
    }

    public Comparable poll() {
        if (size == 0)
            return null;

        Comparable val = queueObjects[0];

        for (int i = 1; i < size; i++) {
            queueObjects[i - 1] = queueObjects[i];
        }

        size--;

        return val;
    }

    public Comparable remove() {
        Comparable val = queueObjects[0];

        for (int i = 1; i < size; i++) {
            queueObjects[i - 1] = queueObjects[i];
        }

        size--;

        return val;
    }

}
