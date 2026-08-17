import java.util.HashMap;
import java.util.Scanner;

class Solution {

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int size = 0;
        boolean odd = false;

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int freq : map.values()) {
            if (freq % 2 == 0) {
                size += freq;
            } else {
                size += freq - 1;
                odd = true;
            }
        }

        if (odd) {
            size++;
        }

        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        Solution obj = new Solution();

        int result = obj.longestPalindrome(s);

        System.out.println("Longest Palindrome Length: " + result);

        sc.close();
    }
}
