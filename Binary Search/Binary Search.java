import java.util.*;

public class Main {

    public static boolean binarySearch(int[] arr, int k) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == k) {
                return true;
            } 
            else if (arr[mid] < k) {
                start = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int k = sc.nextInt();

        boolean result = binarySearch(arr, k);

        System.out.println("Element found: " + result);

        sc.close();
    }
}
