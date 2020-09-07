package Java.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import Java.PriorityQueue;

public class Tests {

    class Comobj implements Comparable {
        public int num;
        public String name;

        public Comobj(int num, String name) {
            this.num = num;
            this.name = name;
        }

        public int compareTo(Object o) {
            if (this.num > ((Comobj) o).num) {
                return -1;
            } else {
                return 1;
            }

        }
    }

    PriorityQueue pQueue = new PriorityQueue();

    @Test
    @DisplayName("PriorityQueue Add Method")
    @Timeout(1000)
    void priorityAdd() {
        Comobj x1 = new Comobj(3, "1");
        Comobj x2 = new Comobj(1, "2");
        Comobj x3 = new Comobj(2, "3");

        pQueue.add(x1);
        pQueue.add(x2);

        assertEquals("1", ((Comobj) pQueue.peek()).name, "Queue was not ordered correctly");

        pQueue.add(x3);
        pQueue.remove();
        System.out.println(pQueue.getSize());
        assertEquals("3", ((Comobj) pQueue.peek()).name, "Queue was not ordered correctly");

    }

}
