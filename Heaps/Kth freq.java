import java.util.*;

class Pair {
    int value;
    int freq;

    Pair(int value, int freq) {
        this.value = value;
        this.freq = freq;
    }
}

class Solution {

    public ArrayList<Integer> topKFreq(int[] arr, int k) {

        // Step 1: Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create min heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.freq != b.freq
                    ? a.freq - b.freq
                    : a.value - b.value
        );

        // Step 3: Add pairs to heap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int value = entry.getKey();
            int freq = entry.getValue();

            pq.add(new Pair(value, freq));

            // Keep only k elements
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Extract elements
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            res.add(pq.poll().value);
        }

        // Step 5: Reverse to get highest priority first
        Collections.reverse(res);

        return res;
    }
}

public class Main {

    public static void main(String[] args) {

        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
        int k = 2;

        Solution obj = new Solution();

        ArrayList<Integer> result = obj.topKFreq(arr, k);

        System.out.println(result);
    }
}
