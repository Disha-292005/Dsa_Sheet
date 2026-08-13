import java.util.*;

class Solution {

    int countTriplets(int sum, int arr[]) {
        int count = 0;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {

                int total = arr[i] + arr[left] + arr[right];

                if (total < sum) {
                    // All elements from left+1 to right
                    // will also form a valid triplet
                    count += right - left;
                    left++;
                } 
                else {
                    right--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = sc.nextInt();

        Solution obj = new Solution();

        System.out.println(obj.countTriplets(sum, arr));

        sc.close();
    }
}
