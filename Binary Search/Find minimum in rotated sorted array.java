import java.util.Scanner;

class Solution {

    int search(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            // Left half is sorted
            if (arr[start] <= arr[mid]) {

                if (arr[start] <= key && key < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            // Right half is sorted
            else {

                if (arr[mid] < key && key <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the key to search: ");
        int key = sc.nextInt();

        Solution obj = new Solution();

        int result = obj.search(arr, key);

        System.out.println("Index: " + result);

        sc.close();
    }
}
