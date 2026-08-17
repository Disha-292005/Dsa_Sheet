import java.util.HashMap;
import java.util.Scanner;

class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : ransomNote.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }

            map.put(ch, map.get(ch) - 1);
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
