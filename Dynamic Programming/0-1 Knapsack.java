import java.util.*;

class Solution {

    public int knapsack(int W, int val[], int wt[]) {

        int n = val.length;

        int[][] dp = new int[n][W + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(W, n - 1, val, wt, dp);
    }

    int helper(int capacity, int n, int[] val, int[] wt, int[][] dp) {

        // No capacity left
        if (capacity == 0) {
            return 0;
        }

        // Only item 0 is left
        if (n == 0) {

            if (wt[0] <= capacity) {
                return val[0];
            }

            return 0;
        }

        // Already calculated
        if (dp[n][capacity] != -1) {
            return dp[n][capacity];
        }

        int pick = 0;
        int notPick;

        // Pick current item
        if (capacity >= wt[n]) {

            pick = val[n]
                 + helper(capacity - wt[n], n - 1, val, wt, dp);
        }

        // Don't pick current item
        notPick = helper(capacity, n - 1, val, wt, dp);

        dp[n][capacity] = Math.max(pick, notPick);

        return dp[n][capacity];
    }
}

public class Main {

    public static void main(String[] args) {

        int W = 50;

        int[] val = {60, 100, 120};

        int[] wt = {10, 20, 30};

        Solution obj = new Solution();

        int result = obj.knapsack(W, val, wt);

        System.out.println("Maximum value = " + result);
    }
}
