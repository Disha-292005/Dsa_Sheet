import java.util.*;

class Solution {

    static int nthFibonacci(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return helper(n, dp);
    }

    static int helper(int n, int[] dp) {

        if (n <= 0)
            return 0;

        if (n == 1)
            return 1;

        if (dp[n] != -1)
            return dp[n];

        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);

        return dp[n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int result = nthFibonacci(n);

        System.out.println("The " + n + "th Fibonacci number is: " + result);

        sc.close();
    }
}
