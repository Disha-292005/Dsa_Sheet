import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {

    public static int maxDepth(Node root) {

        if (root == null)
            return 0;

        return Math.max(
            maxDepth(root.left),
            maxDepth(root.right)
        ) + 1;
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \
             4   5
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int result = maxDepth(root);

        System.out.println("Maximum Depth of Binary Tree: " + result);
    }
}
