import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {

    public int diameter(Node root) {

        if (root == null)
            return 0;

        return Math.max(
            height(root.left) + height(root.right) + 1,
            Math.max(
                diameter(root.left),
                diameter(root.right)
            )
        );
    }

    public int height(Node root) {

        if (root == null)
            return 0;

        return 1 + Math.max(
            height(root.left),
            height(root.right)
        );
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

        int result = obj.diameter(root);

        System.out.println("Diameter: " + result);
    }
}
