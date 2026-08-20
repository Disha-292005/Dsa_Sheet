import java.util.*;

class Solution {

    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int[][] dist = new int[n][m];

        // Add all cells containing 1
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {

                    visited[i][j] = true;

                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // Multi-source BFS
        while (!q.isEmpty()) {

            int[] current = q.poll();

            int r = current[0];
            int c = current[1];
            int d = current[2];

            dist[r][c] = d;

            for (int[] di : directions) {

                int nr = r + di[0];
                int nc = c + di[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    !visited[nr][nc]) {

                    visited[nr][nc] = true;

                    q.offer(new int[]{nr, nc, d + 1});
                }
            }
        }

        // Convert dist[][] to ArrayList<ArrayList<Integer>>
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            // Create a fresh row for every i
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < m; j++) {

                row.add(dist[i][j]);
            }

            ans.add(row);
        }

        return ans;
    }
}

public class Main {

    public static void main(String[] args) {

        int[][] grid = {
            {0, 0, 1},
            {0, 0, 0},
            {1, 0, 0}
        };

        Solution obj = new Solution();

        ArrayList<ArrayList<Integer>> result = obj.nearest(grid);

        for (ArrayList<Integer> row : result) {
            System.out.println(row);
        }
    }
}
