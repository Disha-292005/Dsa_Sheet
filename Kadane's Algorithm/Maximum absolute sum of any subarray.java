import java.util.*;

class Solution {

    public int maxAbsoluteSum(int[] arr) {
        int minsum = arr[0];
        int maxsum = arr[0];
        int res = Math.abs(arr[0]);

        for (int i = 1; i < arr.length; i++) {

            maxsum = Math.max(arr[i], maxsum + arr[i]);

            minsum = Math.min(arr[i], minsum + arr[i]);

            res = Math.max(res,
                    Math.max(Math.abs(maxsum), Math.abs(minsum)));
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution obj = new Solution();

        System.out.println(obj.maxAbsoluteSum(arr));

        sc.close();
    }
}
