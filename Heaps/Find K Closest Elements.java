import java.util.*;

class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> dif(b, x) != dif(a, x)
                ? Integer.compare(dif(b, x), dif(a, x))
                : Integer.compare(b, a)
        );

        for (int i = 0; i < arr.length; i++) {

            pq.add(arr[i]);

            if (pq.size() > k)
                pq.poll();
        }

        ArrayList<Integer> res = new ArrayList<>(pq);

        Collections.sort(res);

        return res;
    }

    public int dif(int y, int x) {
        return Math.abs(y - x);
    }
}


// Driver Code
public class Main {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;

        Solution obj = new Solution();

        List<Integer> result = obj.findClosestElements(arr, k, x);

        System.out.println(result);
    }
}
