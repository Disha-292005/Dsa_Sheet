import java.util.*;

class Solution {

    public int kthSmallest(int[] arr, int k) {

        // Max heap of size k
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        // Add first k elements
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        // Process remaining elements
        for (int i = k; i < arr.length; i++) {

            if (arr[i] < pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        // Root of max heap = kth smallest element
        return pq.peek();
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array size
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input k
        int k = sc.nextInt();

        Solution obj = new Solution();

        int result = obj.kthSmallest(arr, k);

        System.out.println(result);

        sc.close();
    }
}
