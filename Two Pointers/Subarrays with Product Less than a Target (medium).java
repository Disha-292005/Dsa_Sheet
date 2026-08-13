import java.util.*;

class Solution {

    public int countSubarray(int[] arr, int k) {
        if (k <= 1) {
            return 0;
        }

        int product = 1;
        int left = 0;
        int count = 0;

        for (int right = 0; right < arr.length; right++) {

            product *= arr[right];

            while (product >= k) {
                product /= arr[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        Solution obj = new Solution();

        System.out.println(obj.countSubarray(arr, k));

        sc.close();
    }
}
