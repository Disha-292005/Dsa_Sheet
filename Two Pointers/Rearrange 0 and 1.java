import java.util.*;

class Solution {

    static void segregate0and1(int arr[]) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            while (left < right && arr[left] == 0) {
                left++;
            }

            while (left < right && arr[right] == 1) {
                right--;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        segregate0and1(arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
