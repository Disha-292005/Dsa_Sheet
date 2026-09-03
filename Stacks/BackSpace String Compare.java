import java.util.*;

class Solution {

    public boolean backspaceCompare(String s, String t) {

        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        String s_1 = helper(s1, s);
        String s_2 = helper(s2, t);

        return s_1.equals(s_2);
    }

    String helper(Stack<Character> q, String s) {

        StringBuilder st = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '#') {
                if (!q.isEmpty())
                    q.pop();
            } else {
                q.push(ch);
            }
        }

        while (!q.isEmpty())
            st.append(q.pop());

        return st.toString();
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        Solution obj = new Solution();

        System.out.println(obj.backspaceCompare(s, t));
    }
}
