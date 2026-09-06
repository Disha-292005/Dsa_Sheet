import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        scan.close();
        String parts="";
        ArrayList<String> st=new ArrayList<>();
        for(char ch:s.toCharArray()){
            if((ch>='A' && ch<='Z')||(ch>='a'&&ch<='z'))parts+=ch;
            else{
                if(!parts.equals("")){
                st.add(parts);
                parts="";
            }
            }
        }
        if(!parts.equals("")) {
            st.add(parts);
        }
        System.out.println(st.size());
        for(String ans:st)System.out.println(ans);
    }
}

