import java.util.*;

class Solution {

    static int smallestSumSubarray(int arr[], int size) {
        int cursum = arr[0];
        int minsum = arr[0];

        for (int i = 1; i < size; i++) {
            cursum = Math.min(arr[i], cursum + arr[i]);
            minsum = Math.min(minsum, cursum);
        }

        return minsum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(smallestSumSubarray(arr, size));

        sc.close();
    }
}
