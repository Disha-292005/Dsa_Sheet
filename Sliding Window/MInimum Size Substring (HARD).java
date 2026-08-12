import java.util.*;

class Solution {

    public static String minWindow(String s, String p) {

        HashMap<Character, Integer> map = new HashMap<>();

        int count = p.length();
        int high = 0;
        int low = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Store frequency of characters in p
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        while (high < s.length()) {

            char ch = s.charAt(high);

            // Character belongs to p
            if (map.containsKey(ch)) {

                if (map.get(ch) > 0) {
                    count--;
                }

                map.put(ch, map.get(ch) - 1);
            }

            // Window contains all characters of p
            while (count == 0) {

                // Update minimum window
                if (high - low + 1 < minLen) {
                    minLen = high - low + 1;
                    start = low;
                }

                char left = s.charAt(low);

                // Remove left character
                if (map.containsKey(left)) {

                    map.put(left, map.get(left) + 1);

                    if (map.get(left) > 0) {
                        count++;
                    }
                }

                low++;
            }

            high++;
        }

        if (minLen == Integer.MAX_VALUE)
            return "";

        return s.substring(start, start + minLen);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string s: ");
        String s = sc.next();

        System.out.print("Enter pattern p: ");
        String p = sc.next();

        String result = Solution.minWindow(s, p);

        System.out.println("Minimum window: " + result);

        sc.close();
    }
}
