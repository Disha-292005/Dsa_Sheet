import java.util.*;

class Solution {

    public int maxSubarraySum(int[] arr, int k) {

        int n = arr.length;
        int sum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int max = sum;

        // Slide the window
        for (int i = k; i < n; i++) {

            sum += arr[i];
            sum -= arr[i - k];

            max = Math.max(max, sum);
        }

        return max;
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

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Solution obj = new Solution();

        int result = obj.maxSubarraySum(arr, k);

        System.out.println("Maximum subarray sum: " + result);

        sc.close();
    }
}
