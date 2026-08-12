import java.util.*;

class Solution {

    public static int smallestSubWithSum(int x, int[] arr) {

        int high = 0;
        int low = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        while (high < arr.length) {

            sum += arr[high];

            while (sum > x) {

                int len = high - low + 1;

                minLen = Math.min(minLen, len);

                sum -= arr[low];
                low++;
            }

            high++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter x: ");
        int x = sc.nextInt();

        int result = Solution.smallestSubWithSum(x, arr);

        System.out.println("Smallest subarray length: " + result);

        sc.close();
    }
}
