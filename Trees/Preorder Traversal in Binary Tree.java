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

    public ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        helper(root, ans);

        return ans;
    }

    void helper(Node root, ArrayList<Integer> ans) {

        if (root == null)
            return;

        // Root
        ans.add(root.data);

        // Left
        helper(root.left, ans);

        // Right
        helper(root.right, ans);
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

        ArrayList<Integer> ans = obj.preOrder(root);

        System.out.println("Preorder Traversal:");
        System.out.println(ans);
    }
}
