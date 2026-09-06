import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        System.out.println(A.length() + B.length());

        if (A.compareTo(B) > 0)
            System.out.println("Yes");
        else
            System.out.println("No");

        StringBuilder a = new StringBuilder(A);
        StringBuilder b = new StringBuilder(B);

        a.setCharAt(0, Character.toUpperCase(a.charAt(0)));
        b.setCharAt(0, Character.toUpperCase(b.charAt(0)));

        System.out.println(a + " " + b);
    }
}
