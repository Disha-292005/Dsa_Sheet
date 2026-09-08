import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        char[] chars= new char[n];
        int[] groups=new int[n];
        int j=0,i=0,g=0;
        while(i<n){
        while(j<n && s.charAt(j)==s.charAt(i))j++;
        groups[g]=j-i;
        chars[g]=s.charAt(i);
        g++;
        i=j;
        }
        long count=0;
        for(int k=0;k<g;k++){
            int len=groups[k];
            count+=(long)len*(len+1)/2;
        }
        for(int k=1;k<g-1;k++){
            if(groups[k]==1 && chars[k-1]==chars[k+1])count+=(long)Math.min(groups[k-1],groups[k+1]);
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
