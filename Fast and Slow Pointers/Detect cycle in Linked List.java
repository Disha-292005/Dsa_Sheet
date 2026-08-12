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

    public boolean detectLoop(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}

public class Main {

    public static void main(String[] args) {

        // Create linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create a loop:
        // 1 → 2 → 3 → 4 → 5
        //         ↑         ↓
        //         ← ← ← ← ←
        head.next.next.next.next.next = head.next.next;

        Solution obj = new Solution();

        boolean result = obj.detectLoop(head);

        System.out.println(result);
    }
}
