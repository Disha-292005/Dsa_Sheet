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
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
       HashMap<Character,Integer> map=new HashMap<>();
       for(char ch:s.toCharArray())map.put(ch,map.getOrDefault(ch,0)+1);
       
       int first=map.get(s.charAt(0));
       boolean same=true;
       for(char ch:map.keySet()){
        if(map.get(ch)!=first){
            same=false;
            break;
        }
       }
       if(same)return "YES";
       
       for(char ch:map.keySet()){
        map.put(ch,map.get(ch)-1);
        int freq=-1;
        boolean valid=true;
        for(char c:map.keySet()){
            int count=map.get(c);
            if(count==0)continue;
            if(freq==-1)freq=count;
            else if(freq!=count){
                valid=false;
                break;
            }
        }map.put(ch, map.get(ch)+1);
        if(valid)return "YES";
       }
       
       return "NO";
       }
    }



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
