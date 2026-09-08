import java.util.*;

class Geeks {

    static int[][] dp;

    static int lcs(String s1, String s2, int i, int j) {

        // Base case
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Characters match
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + lcs(s1, s2, i + 1, j + 1);
        }

        // Characters don't match
        else {
            dp[i][j] = Math.max(
                lcs(s1, s2, i + 1, j),
                lcs(s1, s2, i, j + 1)
            );
        }

        return dp[i][j];
    }

    static int coutChars(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int lcs = lcs(s1, s2, 0, 0);

        return n + m - 2 * lcs;
    }

    // Driver
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(coutChars(s1, s2));

        sc.close();
    }
}
