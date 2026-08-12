import java.util.*;

class Solution {

    public int longestUniqueSubstr(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int low = 0;
        int high = 0;
        int maxLen = -1;

        char[] ch = s.toCharArray();

        while (high < ch.length) {

            // Add current character
            map.put(ch[high],
                    map.getOrDefault(ch[high], 0) + 1);

            // Remove characters until current character is unique
            while (map.get(ch[high]) > 1) {

                map.put(ch[low],
                        map.get(ch[low]) - 1);

                if (map.get(ch[low]) == 0) {
                    map.remove(ch[low]);
                }

                low++;
            }

            // Update maximum length
            maxLen = Math.max(maxLen, high - low + 1);

            high++;
        }

        return maxLen;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.next();

        Solution obj = new Solution();

        int result = obj.longestUniqueSubstr(s);

        System.out.println("Longest unique substring length: " + result);

        sc.close();
    }
}
