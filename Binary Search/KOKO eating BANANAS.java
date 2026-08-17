import java.util.Scanner;

class Solution {

    public int kokoEat(int[] arr, int k) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        int res = -1;

        for (int i = 0; i < arr.length; i++) {
            end = Math.max(end, arr[i]);
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            long hour = helper(arr, mid);

            if (hour > k) {
                start = mid + 1;
            }
            else {
                res = mid;
                end = mid - 1;
            }
        }

        return res;
    }

    long helper(int[] arr, int speed) {
        long val = 0;

        for (int i = 0; i < arr.length; i++) {
            val += arr[i] / speed;

            if (arr[i] % speed != 0) {
                val++;
            }
        }

        return val;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of piles: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter banana piles:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter maximum hours: ");
        int k = sc.nextInt();

        Solution obj = new Solution();

        int result = obj.kokoEat(arr, k);

        System.out.println("Minimum eating speed: " + result);

        sc.close();
    }
}
