import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
}

class Solution {

    public int minDiff(Node root, int k) {

        if (root == null) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        while (root != null) {

            min = Math.min(min, Math.abs(root.data - k));

            if (k < root.data) {
                root = root.left;
            } 
            else if (k > root.data) {
                root = root.right;
            } 
            else {
                return 0;
            }
        }

        return min;
    }
}

public class Main {
    public static void main(String[] args) {

        /*
                8
               / \
              3   10
             / \
            1   6
               / \
              4   7
        */

        Node root = new Node(8);

        root.left = new Node(3);
        root.right = new Node(10);

        root.left.left = new Node(1);
        root.left.right = new Node(6);

        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        Solution obj = new Solution();

        int k = 5;

        int result = obj.minDiff(root, k);

        System.out.println("Minimum Difference = " + result);
    }
}
