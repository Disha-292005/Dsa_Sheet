import java.util.*;

class Solution {

    static int lcs(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(n - 1, m - 1, s1, s2, dp);
    }

    static int helper(int i, int j,
                      String s1, String s2,
                      int[][] dp) {

        // No characters left
        if (i < 0 || j < 0) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Characters match
        if (s1.charAt(i) == s2.charAt(j)) {

            dp[i][j] = 1 + helper(i - 1, j - 1, s1, s2, dp);

        }

        // Characters don't match
        else {

            dp[i][j] = Math.max(
                helper(i - 1, j, s1, s2, dp),
                helper(i, j - 1, s1, s2, dp)
            );
        }

        return dp[i][j];
    }
}

public class Main {

    public static void main(String[] args) {

        String s1 = "abcde";
        String s2 = "ace";

        int result = Solution.lcs(s1, s2);

        System.out.println("LCS length = " + result);
    }
}
