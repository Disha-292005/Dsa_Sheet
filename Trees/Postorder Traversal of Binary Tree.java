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

    public ArrayList<Integer> postOrder(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();

        helper(root, ans);

        return ans;
    }

    void helper(Node root, ArrayList<Integer> ans) {

        if (root == null)
            return;

        // Left
        helper(root.left, ans);

        // Right
        helper(root.right, ans);

        // Root
        ans.add(root.data);
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

        ArrayList<Integer> ans = obj.postOrder(root);

        System.out.println("Postorder Traversal:");
        System.out.println(ans);
    }
}
