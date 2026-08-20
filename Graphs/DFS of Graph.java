import java.util.*;

class Solution {

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> nodes = new ArrayList<>();

        boolean[] visited = new boolean[adj.size()];

        dfs_traversal(0, adj, nodes, visited);

        return nodes;
    }

    void dfs_traversal(
            int source,
            ArrayList<ArrayList<Integer>> adj,
            ArrayList<Integer> nodes,
            boolean[] visited) {

        if (visited[source])
            return;

        visited[source] = true;

        nodes.add(source);

        for (int neighbour : adj.get(source)) {

            if (!visited[neighbour]) {
                dfs_traversal(neighbour, adj, nodes, visited);
            }
        }
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

        ArrayList<Integer> result = obj.dfs(adj);

        System.out.println("DFS Traversal:");
        System.out.println(result);
    }
}
