import java.util.*;

class Solution {

    public int countEdges(ArrayList<ArrayList<Integer>> adj) {

        int count = 0;

        for (ArrayList<Integer> neighbour : adj) {
            count += neighbour.size();
        }

        return count / 2;
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

        int result = obj.countEdges(adj);

        System.out.println("Number of edges = " + result);
    }
}
