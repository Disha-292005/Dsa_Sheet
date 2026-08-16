import java.util.*;

public class Main {

    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public static String removeDuplicates(String s, int k) {

        Stack<Pair> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!st.isEmpty() && st.peek().ch == ch) {
                st.peek().count++;

                if (st.peek().count == k) {
                    st.pop();
                }
            } else {
                st.push(new Pair(ch, 1));
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            Pair curr = st.pop();

            for (int i = 0; i < curr.count; i++) {
                ans.append(curr.ch);
            }
        }

        ans.reverse();

        return ans.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        String result = removeDuplicates(s, k);

        System.out.println("Result: " + result);

        sc.close();
    }
}
