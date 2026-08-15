
import java.util.*;

public class Main {

    public static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && ch == st.peek()) {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        res.reverse();

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String result = removeDuplicates(s);

        System.out.println(result);

        sc.close();
    }
}
