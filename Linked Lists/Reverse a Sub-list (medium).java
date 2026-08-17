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

    Node reverseBetween(int a, int b, Node head) {

        if (head == null || a == b) {
            return head;
        }

        Node cur = head;
        Node prev = null;

        // Move cur to position a
        for (int i = 1; i < a; i++) {
            prev = cur;
            cur = cur.next;
        }

        Node before = prev;
        Node tail = cur;

        // Reverse nodes from a to b
        for (int i = a; i <= b; i++) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // Connect the reversed part with the previous part
        if (before != null) {
            before.next = prev;
        } else {
            head = prev;
        }

        // Connect the reversed part with the remaining part
        tail.next = cur;

        return head;
    }

    // Driver code
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n <= 0) {
            return;
        }

        System.out.println("Enter the elements:");

        Node head = null;
        Node temp = null;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            Node newNode = new Node(x);

            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }

        System.out.print("Enter a: ");
        int a = sc.nextInt();

        System.out.print("Enter b: ");
        int b = sc.nextInt();

        Solution obj = new Solution();

        head = obj.reverseBetween(a, b, head);

        System.out.println("Linked List after reversal:");

        temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        sc.close();
    }
}
