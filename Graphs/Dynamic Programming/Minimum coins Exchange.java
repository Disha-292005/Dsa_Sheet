import java.util.*;

class Solution {

    public int minCoins(int coins[], int sum) {

        int[] dp = new int[sum + 1];

        Arrays.fill(dp, -1);

        int ans = helper(sum, coins, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int helper(int sum, int[] coins, int[] dp) {

        // Sum formed
        if (sum == 0) {
            return 0;
        }

        // Cannot form the sum
        if (sum < 0) {
            return Integer.MAX_VALUE;
        }

        // Already calculated
        if (dp[sum] != -1) {
            return dp[sum];
        }

        int min = Integer.MAX_VALUE;

        // Try every coin
        for (int coin : coins) {

            if (sum >= coin) {

                int result = helper(sum - coin, coins, dp);

                if (result != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + result);
                }
            }
        }

        dp[sum] = min;

        return dp[sum];
    }
}

public class Main {

    public static void main(String[] args) {

        int[] coins = {25, 10, 5};
        int sum = 30;

        Solution obj = new Solution();

        int result = obj.minCoins(coins, sum);

        System.out.println("Minimum number of coins = " + result);
    }
}
