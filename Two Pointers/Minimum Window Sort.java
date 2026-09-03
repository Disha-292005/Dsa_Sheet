import java.util.*;

class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;
        int left = -1, right = -1;
        int max = nums[0], min = nums[n - 1];

        for (int i = 1; i < n; i++) {
            if (nums[i] < max)
                right = i;
            else
                max = nums[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > min)
                left = i;
            else
                min = nums[i];
        }

        if (left == -1)
            return 0;

        return right - left + 1;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        Solution obj = new Solution();

        System.out.println(obj.findUnsortedSubarray(nums));
    }
}
