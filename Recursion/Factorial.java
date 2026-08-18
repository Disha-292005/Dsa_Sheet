import java.util.*;

class Solution {

    int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        Solution obj = new Solution();

        int result = obj.factorial(n);

        System.out.println("Factorial of " + n + " = " + result);

        sc.close();
    }
}
