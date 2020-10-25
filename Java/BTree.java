package Java;

/* This is the implementation of a BinaryTree */

public class BTree {

    private class node {
        Comparable o;
        private node right;
        private node left;

        public node(Comparable o) {
            this.o = o;
            right = null;
            left = null;
        }
    }

    private node root = null;
    private int size = 0;

    public boolean add(Comparable key) {
        if (key == null)
            return false;

        size++;
        return addHelper(key, root);
    }

    private boolean addHelper(Comparable key, node curr) {
        if (curr == null) {
            curr = new node(key);
            return true;
        }

        return addHelper(key, key.compareTo(curr) >= 0 ? curr.right : curr.left);
    }

    public boolean contains(Comparable key) {
        if (key == null)
            return false;

        return containsHelper(key, root);
    }

    private boolean containsHelper(Comparable key, node curr) {
        if (curr == null)
            return false;

        int ans = key.compareTo(curr);

        return ans == 0 ? true : ans > 0 ? containsHelper(key, curr.right) : containsHelper(key, curr.left);
    }

    public boolean remove(Comparable key) {
        if (key == null || contains(key))
            return false;

        size--;
        return removeHelper(key, root, root);

    }

    private boolean removeHelper(Comparable key, node curr, node prev) {
        if (curr == null)
            return false;

        int ans = key.compareTo(curr);

        if (ans == 0)
            if (curr.left == null && curr.right == null) {
                curr = null;
                size--;
                return true;
            } else {
                if (curr.left == null) {
                    if (prev.right == curr) {
                        biggestValue(prev.left).right = curr.right;
                        curr = null;
                    }
                } else if (curr.right == null) {
                    biggestValue(prev.left).right = curr.left;
                    curr = null;
                } else {
                    biggestValue(curr.left).right = curr.right;
                    prev.right = curr.left;
                }
                size--;
                return true;
            }

        else if (ans >= 0)
            return removeHelper(key, curr.right, curr);
        else
            return removeHelper(key, curr.left, curr);
    }

    private node biggestValue(node curr) {
        if (curr.right == null)
            return curr;
        return biggestValue(curr.right);
    }

}