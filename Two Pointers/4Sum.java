import java.util.*;

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {

                    long sum = (long) nums[i] + nums[j]
                             + nums[left] + nums[right];

                    if (sum == target) {

                        ans.add(Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[left],
                            nums[right]
                        ));

                        while (left < right &&
                               nums[left] == nums[left + 1])
                            left++;

                        while (left < right &&
                               nums[right] == nums[right - 1])
                            right--;

                        left++;
                        right--;

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int target = sc.nextInt();

        Solution obj = new Solution();

        List<List<Integer>> ans = obj.fourSum(nums, target);

        System.out.println(ans);
    }
}
