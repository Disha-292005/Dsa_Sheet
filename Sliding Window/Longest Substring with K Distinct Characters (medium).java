import java.util.*;

class Solution {

    public int longestKSubstr(String s, int k) {

        int low = 0;
        int high = 0;
        int maxLen = -1;

        HashMap<Character, Integer> map = new HashMap<>();

        char[] ch = s.toCharArray();

        while (high < ch.length) {

            // Add current character
            map.put(ch[high], map.getOrDefault(ch[high], 0) + 1);

            // Shrink if distinct characters > k
            while (map.size() > k) {

                map.put(ch[low], map.get(ch[low]) - 1);

                if (map.get(ch[low]) == 0) {
                    map.remove(ch[low]);
                }

                low++;
            }

            // Update answer only when exactly k distinct characters
            if (map.size() == k) {
                maxLen = Math.max(maxLen, high - low + 1);
            }

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

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Solution obj = new Solution();

        int result = obj.longestKSubstr(s, k);

        System.out.println("Longest substring length: " + result);

        sc.close();
    }
}
