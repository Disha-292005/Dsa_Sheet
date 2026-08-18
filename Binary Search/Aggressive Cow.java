import java.util.*;

class Solution {
    public int aggressiveCows(int[] arr, int k) {
        Arrays.sort(arr);

        int start = 1;
        int end = arr[arr.length - 1] - arr[0];
        int res = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (canPlace(arr, k, mid)) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return res;
    }

    boolean canPlace(int[] arr, int k, int distance) {
        int cow = 1;
        int prev = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - prev >= distance) {
                cow++;
                prev = arr[i];

                if (cow == k) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = {1, 2, 4, 8, 9};
        int k = 3;

        System.out.println(obj.aggressiveCows(arr, k));
    }
}
