import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    public boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }

        return helper(root.left, root.right);
    }

    boolean helper(Node r1, Node r2) {
        if (r1 == null && r2 == null) {
            return true;
        }

        if (r1 == null || r2 == null) {
            return false;
        }

        return (r1.data == r2.data &&
                helper(r1.left, r2.right) &&
                helper(r1.right, r2.left));
    }
}

public class Main {
    public static void main(String[] args) {

        /*
                 1
                / \
               2   2
              / \ / \
             3  4 4  3
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(2);

        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right.left = new Node(4);
        root.right.right = new Node(3);

        Solution obj = new Solution();

        boolean result = obj.isSymmetric(root);

        System.out.println("Is Symmetric: " + result);
    }
}
