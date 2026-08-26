import java.util.*;

class Solution {

    public int uniquePaths(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]==1 || grid[n-1][m-1]==1)return 0;
        int[][] dp = new int[n][m];

        // Initialize dp with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(n - 1, m - 1, dp, grid);
    }

    int helper(int n, int m, int[][] dp, int[][] grid) {

        // Outside the grid
        if (n < 0 || m < 0) {
            return 0;
        }

        // Obstacle
        if (grid[n][m] == 1) {
            return 0;
        }

        // Starting point
        if (n == 0 && m == 0) {
            return 1;
        }

        // Already calculated
        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        // From top + from left
        dp[n][m] = helper(n - 1, m, dp, grid)
                 + helper(n, m - 1, dp, grid);

        return dp[n][m];
    }
}

public class Main {

    public static void main(String[] args) {

        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        Solution obj = new Solution();

        int result = obj.uniquePaths(grid);

        System.out.println("Number of unique paths = " + result);
    }
}
