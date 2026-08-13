import java.util.*;

class Solution {

    public int maxCircularSum(int arr[]) {
        int sum = arr[0];
        int minsum = arr[0];
        int maxsum = arr[0];

        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];

            maxsum = Math.max(arr[i], maxsum + arr[i]);
            minsum = Math.min(arr[i], minsum + arr[i]);

            max = Math.max(max, maxsum);
            min = Math.min(min, minsum);
        }

        // All elements are negative
        if (max < 0) {
            return max;
        }

        int dif = sum - min;

        return Math.max(max, dif);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution obj = new Solution();

        System.out.println(obj.maxCircularSum(arr));

        sc.close();
    }
}
