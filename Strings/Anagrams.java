import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if(a.length()!=b.length())return false;
       int n=a.length();
        String c=a.toLowerCase();
        String d=b.toLowerCase();
        int[] freq=new int[256];
        for(int i=0;i<n;i++){
            freq[c.charAt(i)-'a']++;
            freq[d.charAt(i)-'a']--;
        }
        for(int i=0;i<256;i++){
            if(freq[i]!=0)return false;
        }
        return true;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
