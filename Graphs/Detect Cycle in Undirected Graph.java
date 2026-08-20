import java.util.*;

class Solution {

    public boolean isCycle(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        // Check every component
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (dfs(i, -1, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean dfs(
            int source,
            int parent,
            ArrayList<ArrayList<Integer>> adj,
            boolean[] visited) {

        visited[source] = true;

        for (int neighbour : adj.get(source)) {

            // Neighbor is not visited
            if (!visited[neighbour]) {

                if (dfs(neighbour, source, adj, visited)) {
                    return true;
                }
            }

            // Neighbor is already visited and is not parent
            else if (neighbour != parent) {

                return true;
            }
        }

        return false;
    }
}

public class Main {

    public static void main(String[] args) {

        int V = 5;

        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 0},
            {3, 4}
        };

        Solution obj = new Solution();

        boolean result = obj.isCycle(V, edges);

        System.out.println("Cycle exists: " + result);
    }
}
