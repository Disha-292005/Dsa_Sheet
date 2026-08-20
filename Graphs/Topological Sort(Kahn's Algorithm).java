import java.util.*;

class Solution {

    public ArrayList<Integer> topoSort(int V, int[][] edges) {

        ArrayList<Integer> ans = new ArrayList<>();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        int[] indegree = new int[V];

        // Create adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Create directed graph
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            // u -> v
            adj.get(u).add(v);

            // Increase indegree of v
            indegree[v]++;
        }

        // Add all vertices having indegree 0
        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // BFS
        while (!q.isEmpty()) {

            int cur = q.poll();

            ans.add(cur);

            for (int neighbour : adj.get(cur)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
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
             Directed graph:

             0 → 1
             0 → 2
             1 → 3
             2 → 3

             Possible topological order:

             0 → 1 → 2 → 3
        */

        int V = 4;

        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 3},
            {2, 3}
        };

        Solution obj = new Solution();

        ArrayList<Integer> result = obj.topoSort(V, edges);

        System.out.println("Topological Sort:");
        System.out.println(result);
    }
}
