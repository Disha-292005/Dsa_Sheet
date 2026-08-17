import java.util.Scanner;

class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            freq[ch - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ransom note: ");
        String ransomNote = sc.nextLine();

        System.out.print("Enter magazine: ");
        String magazine = sc.nextLine();

        Solution obj = new Solution();

        boolean result = obj.canConstruct(ransomNote, magazine);

        System.out.println("Can construct: " + result);

        sc.close();
    }
}
