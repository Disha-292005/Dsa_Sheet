import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {

    public boolean isIdentical(Node r1, Node r2) {

        // Both trees are empty
        if (r1 == null && r2 == null)
            return true;

        // One tree is empty and the other is not
        if (r1 == null || r2 == null)
            return false;

        // Check current node and recursively check left and right
        return r1.data == r2.data
                && isIdentical(r1.left, r2.left)
                && isIdentical(r1.right, r2.right);
    }

    public static void main(String[] args) {

        /*
            Tree 1:          Tree 2:

                1                1
               / \              / \
              2   3            2   3
             /                  /
            4                  4
        */

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);

        Solution obj = new Solution();

        boolean result = obj.isIdentical(root1, root2);

        System.out.println("Are the trees identical? " + result);
    }
}
