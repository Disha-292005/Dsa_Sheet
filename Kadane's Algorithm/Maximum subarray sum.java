import java.util.*;

class Solution {
    public int maxSubArray(int[] arr) {
        int cursum = arr[0];
        int maxsum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            cursum = Math.max(arr[i], cursum + arr[i]);
            maxsum = Math.max(maxsum, cursum);
        }

        return maxsum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        System.out.println(obj.maxSubArray(arr));

        sc.close();
    }
}
