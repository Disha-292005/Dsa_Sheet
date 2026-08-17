import java.util.HashMap;
import java.util.Scanner;

class Solution {

    public char nonRepeatingChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s.toCharArray()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }

        return '$';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        Solution obj = new Solution();

        char result = obj.nonRepeatingChar(s);

        System.out.println("First non-repeating character: " + result);

        sc.close();
    }
}
