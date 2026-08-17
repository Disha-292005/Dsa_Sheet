import java.util.Scanner;

class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int start = 1;
        int end = arr.length - 2;
        int mid = -1;

        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            }
            else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return mid;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements of the mountain array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution obj = new Solution();

        int result = obj.peakIndexInMountainArray(arr);

        System.out.println("Peak index: " + result);
        System.out.println("Peak element: " + arr[result]);

        sc.close();
    }
}
