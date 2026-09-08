import java.util.*;

class Solution {
    public boolean findPattern(String s) {
        if (s.length() % 2 != 0 || s.charAt(0) != 'x')
            return false;

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'x')
                count++;

            else if (s.charAt(i) == 'y' && count > 0)
                count--;

            else
                return false;
        }

        return count == 0;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        Solution obj = new Solution();

        System.out.println(obj.findPattern(s));

        sc.close();
    }
}
