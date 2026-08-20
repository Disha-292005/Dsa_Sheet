import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
}

class Solution {

    int findCeil(Node root, int x) {
        int ans = -1;

        while (root != null) {

            if (root.data == x) {
                return root.data;
            }

            else if (root.data > x) {
                ans = root.data;
                root = root.left;
            }

            else {
                root = root.right;
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

        int x = 7;

        int result = obj.findCeil(root, x);

        System.out.println("Ceil of " + x + " = " + result);
    }
}
