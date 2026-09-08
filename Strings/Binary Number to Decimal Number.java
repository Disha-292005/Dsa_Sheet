import java.util.*;

class Solution {

    public int binaryToDecimal(String b) {
        int n = 0;

        for (int i = 0; i < b.length(); i++) {
            n = n * 2 + (b.charAt(i) - '0');
        }

        return n;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String b = sc.next();

        Solution obj = new Solution();

        System.out.println(obj.binaryToDecimal(b));

        sc.close();
    }
}
