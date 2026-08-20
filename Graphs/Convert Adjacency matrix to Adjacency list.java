import java.util.*;

class Solution {

    public ArrayList<ArrayList<Integer>> matToAdj(int[][] mat) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int V = mat.length;

        // Create V empty lists
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Convert matrix to adjacency list
        for (int i = 0; i < V; i++) {

            for (int j = 0; j < V; j++) {

                if (mat[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        return adj;
    }
}

public class Main {

    public static void main(String[] args) {

        int[][] mat = {
            {0, 1, 1, 0},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {0, 1, 1, 0}
        };

        Solution obj = new Solution();

        ArrayList<ArrayList<Integer>> adj = obj.matToAdj(mat);

        System.out.println("Adjacency List:");

        for (int i = 0; i < adj.size(); i++) {
            System.out.println(i + " -> " + adj.get(i));
        }
    }
}
