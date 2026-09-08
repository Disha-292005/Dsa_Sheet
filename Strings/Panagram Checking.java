import java.util.*;

class Solution {

    public static boolean checkPangram(String s) {

        int[] freq = new int[26];

        s = s.toLowerCase();

        if (s.length() < 26)
            return false;

        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                freq[ch - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(checkPangram(s));

        sc.close();
    }
}
