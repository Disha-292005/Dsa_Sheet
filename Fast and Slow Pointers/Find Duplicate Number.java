import java.util.*;

class Solution {

    public int findDuplicate(int[] arr) {

        int slow = 0;
        int fast = 0;

        // Phase 1: Detect cycle
        while (true) {

            slow = arr[slow];
            fast = arr[arr[fast]];

            if (slow == fast)
                break;
        }

        // Phase 2: Find duplicate
        slow = 0;

        while (slow != fast) {

            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution obj = new Solution();

        int duplicate = obj.findDuplicate(arr);

        System.out.println("Duplicate element: " + duplicate);

        sc.close();
    }
}
