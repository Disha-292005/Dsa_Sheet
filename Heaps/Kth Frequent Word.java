import java.util.*;

class Pair {
    String value;
    int freq;

    Pair(String value, int freq) {
        this.value = value;
        this.freq = freq;
    }
}

class Solution {

    public List<String> topKFrequent(String[] words, int k) {

        // Step 1: Count frequency of each word
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Step 2: Min Heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.freq != b.freq)
                    return a.freq - b.freq;

                // For same frequency, lexicographically larger
                // word should come first in the min heap
                return b.value.compareTo(a.value);
            }
        );

        // Step 3: Keep only k elements in heap
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            pq.add(new Pair(entry.getKey(), entry.getValue()));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Extract elements
        List<String> res = new ArrayList<>();

        while (!pq.isEmpty()) {
            res.add(pq.poll().value);
        }

        // Heap gives reverse order
        Collections.reverse(res);

        return res;
    }
}


// Driver Code
public class Main {

    public static void main(String[] args) {

        String[] words = {
            "i", "love", "leetcode", "i", "love", "coding"
        };

        int k = 2;

        Solution obj = new Solution();

        List<String> result = obj.topKFrequent(words, k);

        System.out.println(result);
    }
}
