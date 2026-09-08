import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'commonChild' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int commonChild(String s1, String s2) {
    // Write your code here
        int n=s1.length();
        int[][] dp=new int[n][n];
        for(int[]row:dp)Arrays.fill(row,-1);
        return helper(0,0,dp,s1,s2);
    }
    public static int helper(int i,int j,int[][]dp,String s1,String s2){
        if(i==s1.length()||j==s2.length())return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int pick=0;
        if(s1.charAt(i)==s2.charAt(j)){
            pick=1+helper(i+1,j+1,dp,s1,s2);
        }
        int notpick=Math.max(helper(i+1,j,dp,s1,s2),helper(i,j+1,dp,s1,s2));
        dp[i][j]=Math.max(pick,notpick);
        return dp[i][j];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
