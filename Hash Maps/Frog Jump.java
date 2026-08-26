import java.util.*;

class Solution {

    public boolean canCross(int[] arr) {
        int n = arr.length;

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        // Create an empty set for every stone
        for (int stone : arr) {
            map.put(stone, new HashSet<>());
        }

        // Starting stone
        map.get(arr[0]).add(0);

        // Process every stone
        for (int stone : arr) {

            for (int jump : map.get(stone)) {

                // Next jump can be jump-1, jump, or jump+1
                for (int nextJump = jump - 1;
                     nextJump <= jump + 1;
                     nextJump++) {

                    if (nextJump <= 0) {
                        continue;
                    }

                    int nextStone = stone + nextJump;

                    // Reached the last stone
                    if (nextStone == arr[n - 1]) {
                        return true;
                    }

                    // If a stone exists at this position
                    if (map.containsKey(nextStone)) {
                        map.get(nextStone).add(nextJump);
                    }
                }
            }
        }

        return false;
    }

    // Driver code
    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] arr = {0, 1, 3, 5, 6, 8, 12, 17};

        boolean result = obj.canCross(arr);

        System.out.println(result);
    }
}
