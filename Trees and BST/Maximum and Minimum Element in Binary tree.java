import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class Solution {

    public static int findMax(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    public static int findMin(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }
}

public class Main {
    public static void main(String[] args) {

        /*
              7
             / \
            8   6
           /
          3

        Maximum = 8
        Minimum = 3
        */

        Node root = new Node(7);
        root.left = new Node(8);
        root.right = new Node(6);
        root.left.left = new Node(3);

        System.out.println(Solution.findMax(root));
        System.out.println(Solution.findMin(root));
    }
}
