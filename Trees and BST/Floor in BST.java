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

    public int findMaxFork(Node root, int k) {
        int ans = -1;

        while (root != null) {
            if (root.data == k) {
                return root.data;
            } 
            else if (root.data < k) {
                ans = root.data;
                root = root.right;
            } 
            else {
                root = root.left;
            }
        }

        return ans;
    }
}

public class Main {

    public static void main(String[] args) {

        /*
                 8
                / \
               4   12
              / \    \
             2   6    14
        */

        Node root = new Node(8);

        root.left = new Node(4);
        root.right = new Node(12);

        root.left.left = new Node(2);
        root.left.right = new Node(6);

        root.right.right = new Node(14);

        Solution obj = new Solution();

        int k = 7;

        int result = obj.findMaxFork(root, k);

        System.out.println("Floor of " + k + " = " + result);
    }
}
