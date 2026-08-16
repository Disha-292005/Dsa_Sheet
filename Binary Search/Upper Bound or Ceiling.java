import java.util.*;

public class Main {

    static int upperBound(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        int idx = arr.length;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (arr[mid] > target) {
                idx = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return idx;
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

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int result = upperBound(arr, target);

        System.out.println("Upper Bound Index: " + result);

        sc.close();
    }
}
