import java.util.*;

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
}

class Solution {

    public ArrayList<Integer> levelOrder(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Node node = q.poll();

                ans.add(node.data);

                if (node.left != null)
                    q.offer(node.left);

                if (node.right != null)
                    q.offer(node.right);
            }
        }

        return ans;
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

        ArrayList<Integer> ans = obj.levelOrder(root);

        System.out.println("Level Order Traversal:");
        System.out.println(ans);
    }
}
