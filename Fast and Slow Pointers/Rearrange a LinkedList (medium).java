import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {

    public void reorderList(Node head) {

        if (head == null || head.next == null)
            return;

        // Find middle
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Separate second half
        Node second = slow.next;
        slow.next = null;

        // Reverse second half
        second = reverse(second);

        // Merge both halves
        Node first = head;

        while (second != null) {

            Node firstNext = first.next;
            Node secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }

    Node reverse(Node head) {

        Node prev = null;
        Node cur = head;

        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Linked list is empty");
            return;
        }

        System.out.println("Enter node values:");

        Node head = new Node(sc.nextInt());
        Node cur = head;

        for (int i = 1; i < n; i++) {
            cur.next = new Node(sc.nextInt());
            cur = cur.next;
        }

        Solution obj = new Solution();

        obj.reorderList(head);

        System.out.println("Reordered list:");

        cur = head;

        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }

        sc.close();
    }
}
