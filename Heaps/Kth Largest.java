import java.util.*;

class Solution {

    public static int kthLargest(int arr[], int k) {

        // Min heap of size k
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add first k elements
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        // Process remaining elements
        for (int i = k; i < arr.length; i++) {

            if (arr[i] > pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        // Root of min heap = kth largest
        return pq.peek();
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input k
        int k = sc.nextInt();

        // Create Solution object
        Solution obj = new Solution();

        // Find kth largest
        int result = obj.kthLargest(arr, k);

        // Print result
        System.out.println(result);

        sc.close();
    }
}
