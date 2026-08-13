import java.util.*;

class Solution {

    int maxProduct(int[] arr) {
        int maxend = arr[0];
        int minend = arr[0];
        int maxprod = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int temp1 = maxend * arr[i];
            int temp2 = minend * arr[i];

            maxend = Math.max(arr[i], Math.max(temp1, temp2));
            minend = Math.min(arr[i], Math.min(temp1, temp2));

            maxprod = Math.max(maxprod, maxend);
        }

        return maxprod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution obj = new Solution();

        System.out.println(obj.maxProduct(arr));

        sc.close();
    }
}
