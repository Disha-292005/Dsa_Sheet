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

    public boolean search(Node root, int key) {

        if (root == null) {
            return false;
        }

        if (key == root.data) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
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
                / \   /
               4   7 13
        */

        Node root = new Node(8);

        root.left = new Node(3);
        root.right = new Node(10);

        root.left.left = new Node(1);
        root.left.right = new Node(6);

        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        Solution obj = new Solution();

        int key = 7;

        boolean result = obj.search(root, key);

        System.out.println("Key " + key + " found: " + result);
    }
}
