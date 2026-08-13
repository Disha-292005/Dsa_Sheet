import java.util.*;

public class Main {
    public static int pivotIndex(int[] arr) {
        int left = 0;
        int sum = 0;

        // Calculate total sum
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // Find pivot index
        for (int i = 0; i < arr.length; i++) {
            int right = sum - arr[i] - left;

            if (left == right) {
                return i;
            }

            left += arr[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = pivotIndex(arr);

        System.out.println("Pivot Index: " + result);

        sc.close();
    }
}
