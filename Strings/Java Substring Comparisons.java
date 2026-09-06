import java.util.Scanner;

public class Solution {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        int n = s.length();

        String[] st = new String[n - k + 1];

        int j = 0;

        for (int i = k; i <= s.length(); i++) {
            st[j++] = s.substring(i - k, i);
        }

        java.util.Arrays.sort(st);

        smallest = st[0];
        largest = st[st.length - 1];

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        int k = scan.nextInt();

        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
