import java.util.*;

class Solution {

    public int[] sortedSquares(int[] nums) {
        int m = nums.length;

        int[] neg = new int[m];
        int[] pos = new int[m];

        int p = 0, n = 0;

        // Separate negative and positive squares
        for (int i = 0; i < m; i++) {
            if (nums[i] < 0) {
                neg[n++] = nums[i] * nums[i];
            } else {
                pos[p++] = nums[i] * nums[i];
            }
        }

        // Reverse negative squares
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int temp = neg[left];
            neg[left] = neg[right];
            neg[right] = temp;

            left++;
            right--;
        }

        // Merge two sorted arrays
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < p) {
            if (neg[i] < pos[j]) {
                nums[k++] = neg[i++];
            } else {
                nums[k++] = pos[j++];
            }
        }

        while (i < n) {
            nums[k++] = neg[i++];
        }

        while (j < p) {
            nums[k++] = pos[j++];
        }

        return nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution obj = new Solution();

        int[] result = obj.sortedSquares(nums);

        for (int x : result) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}
