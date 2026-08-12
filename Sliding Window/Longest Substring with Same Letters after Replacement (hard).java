import java.util.*;

class Solution {

    public int longestSubstr(String s, int k) {

        int[] freq = new int[26];

        int low = 0;
        int high = 0;
        int maxFreq = 0;
        int maxLen = Integer.MIN_VALUE;

        while (high < s.length()) {

            char ch = s.charAt(high);

            // Add current character
            freq[ch - 'A']++;

            // Find maximum frequency
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // Number of characters that need replacement > k
            while ((high - low + 1) - maxFreq > k) {

                freq[s.charAt(low) - 'A']--;

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

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Solution obj = new Solution();

        int result = obj.longestSubstr(s, k);

        System.out.println("Longest substring length: " + result);

        sc.close();
    }
}
