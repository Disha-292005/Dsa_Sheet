import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int count = 0;

        // Remainder 0 has occurred once initially
        map.put(0, 1);

        for (int num : arr) {
            prefixSum += num;

            int remainder = prefixSum % k;

            // Java can give negative remainder
            if (remainder < 0) {
                remainder += k;
            }

            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 5, 0, -2, -3, 1};
        int k = 5;

        Solution obj = new Solution();

        int result = obj.subarraysDivByK(arr, k);

        System.out.println(result);
    }
}
