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
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        ListNode before = null;

        while (cur != null && cur.next != null) {

            ListNode prev = null;
            ListNode tail = cur;

            // Reverse 2 nodes
            for (int i = 0; i < 2; i++) {
                ListNode nex = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nex;
            }

            // Connect previous pair
            if (before != null) {
                before.next = prev;
            } else {
                head = prev;
            }

            // Connect current pair to remaining nodes
            tail.next = cur;

            // Move before to the tail
            before = tail;
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
        ListNode temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }

        return head;
    }

    // Print linked list
    static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        ListNode head = createList(arr);

        System.out.println("Original Linked List:");
        printList(head);

        Solution obj = new Solution();
        head = obj.swapPairs(head);

        System.out.println("After Swapping Pairs:");
        printList(head);
    }
}
