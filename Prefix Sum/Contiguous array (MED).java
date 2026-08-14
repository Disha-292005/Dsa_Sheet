import java.util.HashMap;

class Solution {
    public int maxLen(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int diff = 0;
        int max = 0;

        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                diff--;
            } else {
                diff++;
            }

            if (map.containsKey(diff)) {
                int idx = map.get(diff);
                int len = i - idx;
                max = Math.max(max, len);
            } else {
                map.put(diff, i);
            }
        }

        return max;
    }
}

public class Main {
    public static void main(String[] args) {

        int[] arr = {0, 0, 1, 0, 0, 0, 1, 1};

        Solution obj = new Solution();

        System.out.println(obj.maxLen(arr));
    }
}
