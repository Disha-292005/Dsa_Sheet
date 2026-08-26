import java.util.*;

class Solution {

    int minCost(int[] height) {

        int n = height.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return helper(n - 1, dp, height);
    }

    int helper(int n, int[] dp, int[] height) {

        // Starting stair
        if (n == 0) {
            return 0;
        }

        // Already calculated
        if (dp[n] != -1) {
            return dp[n];
        }

        // Come from previous stair
        int oneStep =
            Math.abs(height[n] - height[n - 1])
            + helper(n - 1, dp, height);

        // Come from two stairs before
        int twoStep = Integer.MAX_VALUE;

        if (n > 1) {
            twoStep =
                Math.abs(height[n] - height[n - 2])
                + helper(n - 2, dp, height);
        }

        dp[n] = Math.min(oneStep, twoStep);

        return dp[n];
    }
}

public class Main {

    public static void main(String[] args) {

        int[] height = {10, 30, 20, 40};

        Solution obj = new Solution();

        int result = obj.minCost(height);

        System.out.println("Minimum cost = " + result);
    }
}
