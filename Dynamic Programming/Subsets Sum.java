import java.util.*;

class Solution {

    static boolean isSubsetSum(int arr[], int sum) {

        int n = arr.length;

        Boolean[][] dp = new Boolean[n][sum + 1];

        return helper(0, sum, dp, arr);
    }

    static boolean helper(int n, int sum, Boolean[][] dp, int[] arr) {

        // Sum achieved
        if (sum == 0) {
            return true;
        }

        // No elements left
        if (n == arr.length) {
            return false;
        }

        // Already calculated
        if (dp[n][sum] != null) {
            return dp[n][sum];
        }

        boolean pick = false;
        boolean notPick;

        // Pick current element
        if (sum >= arr[n]) {
            pick = helper(n + 1, sum - arr[n], dp, arr);
        }

        // Don't pick current element
        notPick = helper(n + 1, sum, dp, arr);

        dp[n][sum] = pick || notPick;

        return dp[n][sum];
    }
}

public class Main {

    public static void main(String[] args) {

        int[] arr = {3, 34, 4, 12, 5, 2};

        int sum = 9;

        boolean result = Solution.isSubsetSum(arr, sum);

        System.out.println("Subset with sum " + sum + " exists: " + result);
    }
}
