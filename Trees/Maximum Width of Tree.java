import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {

    public int maxWidth(Node root) {

        if (root == null)
            return 0;

        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        int max = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            max = Math.max(max, size);

            for (int i = 0; i < size; i++) {

                Node node = q.poll();

                if (node.left != null)
                    q.offer(node.left);

                if (node.right != null)
                    q.offer(node.right);
            }
        }

        return max;
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \   \
             4   5   6
                / \
               7   8
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);

        Solution obj = new Solution();

        int result = obj.maxWidth(root);

        System.out.println("Maximum Width of Binary Tree: " + result);
    }
}
