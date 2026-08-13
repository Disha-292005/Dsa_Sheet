import java.util.*;

class Solution {

    public int maxSumSubarray(int[] arr) {
        int nodelete = arr[0];
        int onedelete = arr[0];
        int res = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int prev_nodelete = nodelete;
            int prev_onedelete = onedelete;

            nodelete = Math.max(arr[i],
                                prev_nodelete + arr[i]);

            onedelete = Math.max(prev_nodelete,
                                 prev_onedelete + arr[i]);

            res = Math.max(res,
                           Math.max(nodelete, onedelete));
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

        System.out.println(obj.maxSumSubarray(arr));

        sc.close();
    }
}
