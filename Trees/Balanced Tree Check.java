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

    public boolean isBalanced(Node root) {

        if (root == null)
            return true;

        if (Math.abs(helper(root.left) - helper(root.right)) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int helper(Node root) {

        if (root == null)
            return 0;

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

        boolean result = obj.isBalanced(root);

        System.out.println("Is the tree balanced? " + result);
    }
}
