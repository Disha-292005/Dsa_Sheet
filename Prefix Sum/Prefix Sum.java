import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> prefSum(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();

        int[] prefix = new int[arr.length];

        prefix[0] = arr[0];
        ans.add(prefix[0]);

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
            ans.add(prefix[i]);
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

        int[] arr = {10, 20, 10, 5, 15};

        Solution obj = new Solution();

        ArrayList<Integer> result = obj.prefSum(arr);

        System.out.println(result);
    }
}
