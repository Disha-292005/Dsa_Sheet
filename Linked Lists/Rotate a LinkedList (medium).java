import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {

    public Node rotate(Node head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        Node cur = head;

        // Find length and last node
        while (cur.next != null) {
            length++;
            cur = cur.next;
        }

        // Reduce unnecessary rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Make the list circular
        cur.next = head;

        // Find new tail
        Node tail = head;

        for (int i = 1; i < k; i++) {
            tail = tail.next;
        }

        // New head
        Node newHead = tail.next;

        // Break the circular list
        tail.next = null;

        return newHead;
    }
}

public class Main {

    static Node createList(int[] arr) {

        if (arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node cur = head;

        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node(arr[i]);
            cur = cur.next;
        }

        return head;
    }

    static void printList(Node head) {

        Node cur = head;

        while (cur != null) {
            System.out.print(cur.data);

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

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Node head = createList(arr);

        System.out.println("Original list:");
        printList(head);

        Solution obj = new Solution();

        head = obj.rotate(head, k);

        System.out.println("After left rotation:");
        printList(head);

        sc.close();
    }
}
