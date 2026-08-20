import java.util.*;

class Solution {

    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        for (int i = 0; i < edges.size(); i++) {

            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        int count = 0;

        // Find every unvisited component
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                dfs(i, adj, visited);

                count++;
            }
        }

        return count;
    }

    void dfs(
            int source,
            ArrayList<ArrayList<Integer>> adj,
            boolean[] visited) {

        if (visited[source])
            return;

        visited[source] = true;

        for (int neighbour : adj.get(source)) {

            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited);
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        /*
              0 ----- 1
              |       |
              |       |
              2       3

              4 ----- 5

              Components:

              Component 1: {0, 1, 2, 3}
              Component 2: {4, 5}

              Total = 2
        */

        int V = 6;

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(Arrays.asList(0, 2)));
        edges.add(new ArrayList<>(Arrays.asList(1, 3)));
        edges.add(new ArrayList<>(Arrays.asList(4, 5)));

        Solution obj = new Solution();

        int result = obj.countConnected(V, edges);

        System.out.println("Number of connected components = " + result);
    }
}
