
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
    int maximum = Integer.MIN_VALUE;

    int findMaxSum(Node root) {
        if (root == null) {
            return 0;
        }

        helper(root);
        return maximum;
    }

    int helper(Node root) {
        if (root == null) {
            return 0;
        }

        int l = Math.max(0, helper(root.left));
        int r = Math.max(0, helper(root.right));

        maximum = Math.max(maximum, l + r + root.data);

        return Math.max(l, r) + root.data;
    }
}

public class Main {
    public static void main(String[] args) {

        /*
                 10
                /  \
               2    10
              / \     \
             20  1    -25
                      /  \
                     3    4

            Maximum Path Sum = 42
            Path: 20 -> 2 -> 10 -> 10
        */

        Node root = new Node(10);

        root.left = new Node(2);
        root.right = new Node(10);

        root.left.left = new Node(20);
        root.left.right = new Node(1);

        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);

        Solution obj = new Solution();

        int result = obj.findMaxSum(root);

        System.out.println("Maximum Path Sum = " + result);
    }
}
