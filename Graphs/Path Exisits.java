import java.util.*;

class Solution {

    public boolean checkPath(int V, int[][] edges, int src, int dest) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            // Undirected graph
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        return dfs(src, dest, adj, visited);
    }

    boolean dfs(
            int src,
            int dest,
            ArrayList<ArrayList<Integer>> adj,
            boolean[] visited) {

        // Destination reached
        if (src == dest) {
            return true;
        }

        visited[src] = true;

        for (int neighbour : adj.get(src)) {

            if (!visited[neighbour]) {

                if (dfs(neighbour, dest, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}

public class Main {

    public static void main(String[] args) {

        /*
                 0
                / \
               1   2
               |   |
               3   4

            Edges:
            0-1
            0-2
            1-3
            2-4
        */

        int V = 5;

        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 3},
            {2, 4}
        };

        int src = 0;
        int dest = 4;

        Solution obj = new Solution();

        boolean result = obj.checkPath(V, edges, src, dest);

        System.out.println("Path exists from " + src +
                           " to " + dest + ": " + result);
    }
}
