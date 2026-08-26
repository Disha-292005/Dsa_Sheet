import java.util.*;

class Solution {

    public int lis(int arr[]) {

        int n = arr.length;

        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(0, -1, dp, arr);
    }

    int helper(int n, int prev, int[][] dp, int[] arr) {

        // No elements left
        if (n == arr.length) {
            return 0;
        }

        // Already calculated
        if (dp[n][prev + 1] != -1) {
            return dp[n][prev + 1];
        }

        int pick = 0;
        int notPick;

        // Pick current element
        if (prev == -1 || arr[n] > arr[prev]) {

            pick = 1 + helper(n + 1, n, dp, arr);
        }

        // Don't pick current element
        notPick = helper(n + 1, prev, dp, arr);

        dp[n][prev + 1] = Math.max(pick, notPick);

        return dp[n][prev + 1];
    }
}

public class Main {

    public static void main(String[] args) {

        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};

        Solution obj = new Solution();

        int result = obj.lis(arr);

        System.out.println("Length of LIS = " + result);
    }
}
