import java.util.*;

class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        // Case 1: Exclude first house
        int case1 = helper(n - 1, 1, dp1, nums);

        // Case 2: Exclude last house
        int case2 = helper(n - 2, 0, dp2, nums);

        return Math.max(case1, case2);
    }

    int helper(int n, int start, int[] dp, int[] nums) {

        if (n < start) {
            return 0;
        }

        if (n == start) {
            return nums[n];
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int pick = nums[n] + helper(n - 2, start, dp, nums);

        int notpick = helper(n - 1, start, dp, nums);

        dp[n] = Math.max(pick, notpick);

        return dp[n];
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] nums = {2, 3, 2};

        System.out.println(obj.rob(nums));
    }
}
