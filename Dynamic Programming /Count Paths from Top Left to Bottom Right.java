import java.util.*;

class Solution {

    public int numberOfPaths(int m, int n) {

        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(m - 1, n - 1, dp);
    }

    int helper(int i, int j, int[][] dp) {

        // Starting point
        if (i == 0 && j == 0) {
            return 1;
        }

        // Outside grid
        if (i < 0 || j < 0) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = helper(i - 1, j, dp);

        int left = helper(i, j - 1, dp);

        dp[i][j] = up + left;

        return dp[i][j];
    }
}

public class Main {

    public static void main(String[] args) {

        int m = 3;
        int n = 3;

        Solution obj = new Solution();

        System.out.println(obj.numberOfPaths(m, n));
    }
}
