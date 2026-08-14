import java.util.HashMap;

class Solution {
    public int subarraySum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixsum = 0;
        int count = 0;

        map.put(0, 1);

        for (int i : arr) {
            prefixsum += i;

            if (map.containsKey(prefixsum - k)) {
                count += map.get(prefixsum - k);
            }

            map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        int k = 3;

        Solution obj = new Solution();

        int result = obj.subarraySum(arr, k);

        System.out.println(result);
    }
}
