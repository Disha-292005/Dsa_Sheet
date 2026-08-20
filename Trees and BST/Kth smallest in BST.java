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

    public int kthSmallest(Node root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        return helper(root, k, ans);
    }

    int helper(Node root, int k, ArrayList<Integer> ans) {

        if (root == null)
            return -1;

        // Visit left subtree
        int left = helper(root.left, k, ans);

        if (left != -1)
            return left;

        // Visit root
        ans.add(root.data);

        if (ans.size() == k)
            return ans.get(k - 1);

        // Visit right subtree
        return helper(root.right, k, ans);
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

        int k = 3;

        int result = obj.kthSmallest(root, k);

        System.out.println("Kth smallest element = " + result);
    }
}
