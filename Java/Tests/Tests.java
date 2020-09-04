package Java.Tests;

public class Tests {

    class Comobj implements Comparable {
        public int com;
        public String name;

        public int compareTo(Object o) {
            if (this.com > ((Comobj) o).com) {
                return -1;

            } else {
                return 1;
            }

        }

    }

}
