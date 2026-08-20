import java.util.*;

class Solution {

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        // Add all initially rotten oranges
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }

                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;

        int[][] directions = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1}    // right
        };

        // BFS
        while (!q.isEmpty()) {

            int size = q.size();

            boolean rotted = false;

            for (int i = 0; i < size; i++) {

                int[] current = q.poll();

                int r = current[0];
                int c = current[1];

                for (int[] dir : directions) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;

                        fresh--;

                        q.offer(new int[]{nr, nc});

                        rotted = true;
                    }
                }
            }

            if (rotted) {
                time++;
            }
        }

        // If fresh oranges remain, they cannot be rotten
        if (fresh > 0) {
            return -1;
        }

        return time;
    }
}

public class Main {

    public static void main(String[] args) {

        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        Solution obj = new Solution();

        int result = obj.orangesRotting(grid);

        System.out.println("Minimum time = " + result);
    }
}
