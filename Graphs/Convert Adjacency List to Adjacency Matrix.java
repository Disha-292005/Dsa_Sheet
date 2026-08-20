import java.util.*;

class Solution {

    public int[][] adjToMat(ArrayList<ArrayList<Integer>> adj) {

        int V = adj.size();

        int[][] matrix = new int[V][V];

        for (int i = 0; i < V; i++) {

            for (int neighbour : adj.get(i)) {

                matrix[i][neighbour] = 1;
            }
        }

        return matrix;
    }
}

public class Main {

    public static void main(String[] args) {

        /*
             Graph:

             0 ---- 1
             |      |
             |      |
             2 ---- 3

             Adjacency List:
             0 -> [1, 2]
             1 -> [0, 3]
             2 -> [0, 3]
             3 -> [1, 2]
        */

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 3)));
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));

        Solution obj = new Solution();

        int[][] matrix = obj.adjToMat(adj);

        System.out.println("Adjacency Matrix:");

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}
