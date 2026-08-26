import java.util.*;

class Solution {

    public int countWays(int n) {

        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return helper(n, dp);
    }

    int helper(int n, int[] dp) {

        // Base cases
        if (n == 0 || n == 1) {
            return 1;
        }

        // Already calculated
        if (dp[n] != -1) {
            return dp[n];
        }

        // Take 1 step or 2 steps
        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);

        return dp[n];
    }
}

public class Main {

    public static void main(String[] args) {

        int n = 5;

        Solution obj = new Solution();

        int result = obj.countWays(n);

        System.out.println("Number of ways = " + result);
    }
}
