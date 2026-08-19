import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = this.right = null;
    }
}

class Solution {

    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        helper(0, root, ans);

        return ans;
    }

    void helper(int level, Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        // First node encountered at this level
        if (level == ans.size()) {
            ans.add(root.data);
        }

        // Visit left first
        helper(level + 1, root.left, ans);

        // Then visit right
        helper(level + 1, root.right, ans);
    }
}

public class Main {
    public static void main(String[] args) {

        /*
                  1
                /   \
               2     3
              / \   / \
             4   5 6   7
                /
               8

            Left View = 1 2 4 8
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.right.left = new Node(8);

        Solution obj = new Solution();

        ArrayList<Integer> result = obj.leftView(root);

        System.out.println("Left View: " + result);
    }
}
