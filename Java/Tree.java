package Java;

/* This is the implementation of a Non-BinaryTree */

public class Tree {

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
        String path = shortestPath(root);
        return addHelper(key, root, root == null ? null : path);

    }

    private boolean addHelper(Comparable key, node curr, String path) {
        if (curr == null) {
            curr = new node(key);
            return true;
        }

        curr = path.charAt(0) == 'R' ? curr.right : curr.left;

        path = path.substring(0);

        return addHelper(key, curr, path);
    }

    private String shortestPath(node root) {

        String path = "";

        return shortestPathHelper(root, path);
    }

    private String shortestPathHelper(node curr, String path) {
        if (curr == null) {
            return path;
        }

        String rightPath = shortestPathHelper(curr.right, path += "R");
        String leftPath = shortestPathHelper(curr.left, path += "L");

        if (rightPath.length() >= leftPath.length()) {
            return leftPath;
        } else {
            return rightPath;
        }
    }

    public boolean contains(Comparable key) {
        if (key == null)
            return false;

        return containsHelper(key, root);
    }

    private boolean containsHelper(Comparable key, node curr) {
        if (curr == null)
            return false;

        boolean right = containsHelper(key, curr.right);

        boolean left = false;
        if (!right)
            left = containsHelper(key, curr.left);

        if (right || left)
            return true;

        return key.compareTo(curr) >= 0 ? true : false;
    }

    public boolean remove(Comparable key) {

        if (key == null)
            return false;

        if (contains(key))
            return removeHelper(key, root, root);
        return false;

    }

    private boolean removeHelper(Comparable key, node curr, node prev) {
        if (curr == null) {
            return false;
        }
        if (key.compareTo(curr) == 0)
            if (curr.left == null && curr.right == null) {
                curr = null;
                size--;
                return true;
            } else {
                if (prev.right == curr) {

                    if (curr.right == null)
                        prev.right = curr.left;
                    else if (curr.left == null)
                        prev.right = curr.right;
                    else {
                        leftMostNode(curr).left = curr.right;
                        prev.right = curr.left;
                    }
                } else {
                    if (curr.right == null)
                        prev.left = curr.left;
                    else if (curr.left == null)
                        prev.left = curr.right;
                    else {
                        leftMostNode(curr).left = curr.right;
                        prev.left = curr.left;
                    }

                }

                size--;
                return true;
            }

        boolean right = removeHelper(key, curr.right, curr);

        boolean left = false;
        if (!right)
            left = removeHelper(key, curr.left, curr);

        return right || left;
    }

    private node leftMostNode(node curr) {
        if (curr.left == null)
            return curr;
        return leftMostNode(curr.left);
    }

    private int longestPath(node curr) {
        return longestPathHelper(curr, 0);
    }

    private int longestPathHelper(node curr, int i) {
        if (curr == null) {
            return i;
        }

        i++;

        int right = longestPathHelper(curr.right, i);
        int left = longestPathHelper(curr.left, i);

        return left > right ? left : right;
    }

    public int size() {
        return size;
    }
}