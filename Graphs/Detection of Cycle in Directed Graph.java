import java.util.*;

class Solution {

    public boolean isCyclic(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int[] indegree = new int[V];

        // Create adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Directed graph
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // Add vertices with indegree 0
        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;

        // Kahn's Algorithm
        while (!q.isEmpty()) {

            int cur = q.poll();

            count++;

            for (int neighbour : adj.get(cur)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }
        }

        // If all vertices are processed → no cycle
        // Otherwise → cycle exists
        return count != V;
    }
}

public class Main {

    public static void main(String[] args) {

        int V = 4;

        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 0},
            {2, 3}
        };

        Solution obj = new Solution();

        boolean result = obj.isCyclic(V, edges);

        System.out.println("Cycle exists: " + result);
    }
}
