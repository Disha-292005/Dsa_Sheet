import java.util.*;

class Solution {

    public List<List<Integer>> printGraph(int V, int edges[][]) {

        List<List<Integer>> adj = new ArrayList<>();

        // Create V empty lists
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

        return adj;
    }
}

public class Main {

    public static void main(String[] args) {

        int V = 5;

        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 3},
            {2, 4}
        };

        Solution obj = new Solution();

        List<List<Integer>> result = obj.printGraph(V, edges);

        // Print adjacency list
        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + result.get(i));
        }
    }
}
