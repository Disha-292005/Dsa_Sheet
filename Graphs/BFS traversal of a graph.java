import java.util.*;

class Solution {

    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans = new ArrayList<>();

        boolean[] visited = new boolean[adj.size()];

        return bfs_traversal(adj, ans, visited);
    }

    ArrayList<Integer> bfs_traversal(
            ArrayList<ArrayList<Integer>> adj,
            ArrayList<Integer> ans,
            boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();

        // Start BFS from vertex 0
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {

            int cur = q.poll();

            ans.add(cur);

            for (int neighbour : adj.get(cur)) {

                if (!visited[neighbour]) {

                    visited[neighbour] = true;
                    q.offer(neighbour);
                }
            }
        }

        return ans;
    }
}

public class Main {

    public static void main(String[] args) {

        /*
                 0
                / \
               1   2
               |   |
               3---4

            Adjacency List:

            0 -> [1, 2]
            1 -> [0, 3]
            2 -> [0, 4]
            3 -> [1, 4]
            4 -> [2, 3]
        */

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1, 4)));
        adj.add(new ArrayList<>(Arrays.asList(2, 3)));

        Solution obj = new Solution();

        ArrayList<Integer> result = obj.bfs(adj);

        System.out.println("BFS Traversal:");
        System.out.println(result);
    }
}
