import java.util.*;

class Solution {

    public boolean reachesOne(int n) {

        int slow = n;
        int fast = n;

        while (fast != 1) {

            slow = helper(slow);
            fast = helper(helper(fast));

            if (slow == fast && slow != 1) {
                return false;
            }
        }

        return true;
    }

    int helper(int n) {

        int sum = 0;

        while (n > 0) {
            int d = n % 10;
            sum = sum + d * d;
            n = n / 10;
        }

        return sum;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        Solution obj = new Solution();

        boolean result = obj.reachesOne(n);

        System.out.println(result);

        sc.close();
    }
}
