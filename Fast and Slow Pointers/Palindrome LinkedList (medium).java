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

    public boolean isPalindrome(Node head) {

        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        // Find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node second = reverse(slow);

        // Compare both halves
        Node first = head;

        while (second != null) {

            if (first.data != second.data)
                return false;

            first = first.next;
            second = second.next;
        }

        return true;
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
            System.out.println("Empty linked list");
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

        boolean result = obj.isPalindrome(head);

        System.out.println("Is Palindrome: " + result);

        sc.close();
    }
}
