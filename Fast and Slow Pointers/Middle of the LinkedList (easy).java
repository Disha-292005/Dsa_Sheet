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

    int getMiddle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
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

        int middle = obj.getMiddle(head);

        System.out.println("Middle element: " + middle);

        sc.close();
    }
}
