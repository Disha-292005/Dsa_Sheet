import java.util.*;

public class Main {

    public static String reverseString(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder s1 = new StringBuilder();

        for (char ch : s.toCharArray()) {
            st.push(ch);
        }

        while (!st.isEmpty()) {
            s1.append(st.pop());
        }

        return s1.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String result = reverseString(s);

        System.out.println(result);

        sc.close();
    }
}
