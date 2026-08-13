import java.util.*;

class Solution {

    public int closest3Sum(int[] arr, int target) {
        Arrays.sort(arr);

        int closest = arr[0] + arr[1] + arr[2];

        for (int i = 0; i < arr.length - 2; i++) {

            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {

                int sum = arr[i] + arr[left] + arr[right];

                if (Math.abs(sum - target) < Math.abs(closest - target)
                        || (Math.abs(sum - target) == Math.abs(closest - target)
                        && sum > closest)) {
                    closest = sum;
                }

                if (sum == target) {
                    return sum;
                } 
                else if (sum < target) {
                    left++;
                } 
                else {
                    right--;
                }
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        Solution obj = new Solution();

        System.out.println(obj.closest3Sum(arr, target));

        sc.close();
    }
}
