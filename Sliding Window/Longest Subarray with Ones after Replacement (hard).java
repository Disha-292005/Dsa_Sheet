import java.util.*;

class Solution {

    public int maxOnes(int arr[], int k) {

        int low = 0;
        int high = 0;
        int zero = 0;
        int maxLen = Integer.MIN_VALUE;

        while (high < arr.length) {

            // Add current element
            if (arr[high] == 0) {
                zero++;
            }

            // More than k zeros, shrink window
            while (zero > k) {

                if (arr[low] == 0) {
                    zero--;
                }

                low++;
            }

            // Update maximum length
            maxLen = Math.max(maxLen, high - low + 1);

            high++;
        }

        return maxLen;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements (0 or 1):");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Solution obj = new Solution();

        int result = obj.maxOnes(arr, k);

        System.out.println("Maximum consecutive ones: " + result);

        sc.close();
    }
}
