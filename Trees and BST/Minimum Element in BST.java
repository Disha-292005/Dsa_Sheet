import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class Solution {

    public int minValue(Node root) {

        if (root == null) {
            return -1;
        }

        while (root.left != null) {
            root = root.left;
        }

        return root.data;
    }
}

public class Main {
    public static void main(String[] args) {

        /*
                 8
                / \
               3   10
              / \    \
             1   6    14
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

        root.right.right = new Node(14);

        Solution obj = new Solution();

        int result = obj.minValue(root);

        System.out.println("Minimum value = " + result);
    }
}
