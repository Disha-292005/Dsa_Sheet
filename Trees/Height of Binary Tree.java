import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class Solution {

    public int height(Node root) {
        return helper(root);
    }

    public int helper(Node root) {

        if (root == null)
            return -1;

        return Math.max(
            helper(root.left),
            helper(root.right)
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

        Solution obj = new Solution();

        int result = obj.height(root);

        System.out.println("Height of Binary Tree: " + result);
    }
}
