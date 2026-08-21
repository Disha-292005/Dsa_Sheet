import java.util.*;

class Solution {

    public int findMaxSum(int arr[]) {

        int n = arr.length;

        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return helper(n - 1, dp, arr);
    }

    int helper(int n, int[] dp, int[] arr) {

        // No elements
        if (n < 0) {
            return 0;
        }

        // Only one element
        if (n == 0) {
            return arr[0];
        }

        // Already calculated
        if (dp[n] != -1) {
            return dp[n];
        }

        // Pick current OR don't pick current
        int pick = arr[n] + helper(n - 2, dp, arr);

        int notPick = helper(n - 1, dp, arr);

        dp[n] = Math.max(pick, notPick);

        return dp[n];
    }
}

public class Main {

    public static void main(String[] args) {

        int[] arr = {2, 1, 4, 9};

        Solution obj = new Solution();

        int result = obj.findMaxSum(arr);

        System.out.println("Maximum sum = " + result);
    }
}
