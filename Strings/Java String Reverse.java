import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String A = sc.next();

        StringBuilder s = new StringBuilder(A);
        s.reverse();

        if (s.toString().equals(A))
            System.out.println("Yes");
        else
            System.out.println("No");

        sc.close();
    }
}
