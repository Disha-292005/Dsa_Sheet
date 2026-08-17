import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Solution {
    public Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        Node cur = head;
        Node before = null;

        while (cur != null) {
            Node prev = null;
            Node tail = cur;

            // Reverse k nodes
            for (int i = 0; i < k && cur != null; i++) {
                Node next = cur.next;
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

            // Connect current group to remaining nodes
            tail.next = cur;

            before = tail;
        }

        return head;
    }
}

public class Main {

    // Create linked list
    static Node createList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }

        return head;
    }

    // Print linked list
    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;

        Node head = createList(arr);

        System.out.println("Original Linked List:");
        printList(head);

        Solution obj = new Solution();
        head = obj.reverseKGroup(head, k);

        System.out.println("After Reversing in Groups of " + k + ":");
        printList(head);
    }
}
