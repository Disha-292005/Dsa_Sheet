import java.util.*;

class Solution {

    public int[][] kClosest(int[][] points, int k) {

        // Max Heap based on distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(dist(b), dist(a))
        );

        for (int[] row : points) {

            pq.add(row);

            // Keep only k closest points
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.toArray(new int[k][]);
    }

    public double dist(int[] row) {
        return row[0] * row[0] + row[1] * row[1];
    }
}


// Driver Code
public class Main {

    public static void main(String[] args) {

        int[][] points = {
            {1, 3},
            {-2, 2},
            {5, 8},
            {0, 1}
        };

        int k = 2;

        Solution obj = new Solution();

        int[][] result = obj.kClosest(points, k);

        System.out.println("K Closest Points:");

        for (int[] point : result) {
            System.out.println(
                "[" + point[0] + ", " + point[1] + "]"
            );
        }
    }
}
