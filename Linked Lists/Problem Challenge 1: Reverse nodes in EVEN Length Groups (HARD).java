import java.util.Scanner;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public ListNode reverseEvenLengthGroups(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode before = null;
        int groupSize = 1;

        while (cur != null) {

            // Find actual size of current group
            ListNode temp = cur;
            int count = 0;

            while (temp != null && count < groupSize) {
                count++;
                temp = temp.next;
            }

            // Reverse only even-length groups
            if (count % 2 == 0) {

                ListNode tail = cur;
                ListNode prev = null;

                for (int i = 0; i < count; i++) {

                    ListNode next = cur.next;

                    cur.next = prev;
                    prev = cur;
                    cur = next;
                }

                // Connect previous group
                if (before != null) {
                    before.next = prev;
                } else {
                    head = prev;
                }

                // Connect to next group
                tail.next = cur;

                before = tail;

            } else {

                // Move through odd-length group without reversing
                for (int i = 0; i < count; i++) {
                    before = cur;
                    cur = cur.next;
                }
            }

            groupSize++;
        }

        return head;
    }
}

public class Main {

    // Create linked list
    static ListNode createList(int[] arr) {

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
    static void printList(ListNode head) {

        ListNode cur = head;

        while (cur != null) {
            System.out.print(cur.val);

            if (cur.next != null) {
                System.out.print(" -> ");
            }

            cur = cur.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ListNode head = createList(arr);

        System.out.println("Original list:");
        printList(head);

        Solution obj = new Solution();

        head = obj.reverseEvenLengthGroups(head);

        System.out.println("After reversing even length groups:");
        printList(head);

        sc.close();
    }
}
