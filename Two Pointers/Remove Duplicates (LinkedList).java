import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val != prev.val) {
                prev.next = cur;
                prev = prev.next;
            }

            cur = cur.next;
        }

        prev.next = null;

        return head;
    }
}

public class Main {

    // Create linked list from array
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;

        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        return head;
    }

    // Print linked list
    public static void printList(ListNode head) {
        ListNode cur = head;

        while (cur != null) {
            System.out.print(cur.val);

            if (cur.next != null) {
                System.out.print(" ");
            }

            cur = cur.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ListNode head = createList(arr);

        Solution obj = new Solution();

        head = obj.deleteDuplicates(head);

        printList(head);

        sc.close();
    }
}
