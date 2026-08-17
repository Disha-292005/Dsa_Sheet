import java.util.HashMap;
import java.util.Scanner;

class Solution {

    public int maxInstance(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int b = map.getOrDefault('b', 0);
        int a = map.getOrDefault('a', 0);
        int l = map.getOrDefault('l', 0) / 2;
        int o = map.getOrDefault('o', 0) / 2;
        int n = map.getOrDefault('n', 0);

        return Math.min(
            Math.min(b, a),
            Math.min(Math.min(l, o), n)
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        Solution obj = new Solution();

        int result = obj.maxInstance(s);

        System.out.println("Maximum instances of balloon: " + result);

        sc.close();
    }
}
