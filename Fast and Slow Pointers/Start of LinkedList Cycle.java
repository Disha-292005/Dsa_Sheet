class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {

    public int cycleStart(Node head) {

        Node slow = head;
        Node fast = head;

        // Phase 1: Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        // No cycle
        if (fast == null || fast.next == null)
            return -1;

        // Phase 2: Find starting node of cycle
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }
}

public class Main {

    public static void main(String[] args) {

        /*
             1 → 2 → 3 → 4 → 5
                     ↑         ↓
                     ← ← ← ← ←
        */

        Node head = new Node(1);

        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create cycle: 5 → 3
        head.next.next.next.next.next = head.next.next;

        Solution obj = new Solution();

        int result = obj.cycleStart(head);

        System.out.println("Cycle starts at node: " + result);
    }
}
