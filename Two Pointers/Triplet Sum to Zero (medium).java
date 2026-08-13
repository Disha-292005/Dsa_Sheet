import java.util.*;

class Solution {

    public List<List<Integer>> findTriplets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {

            HashMap<Integer, List<Integer>> map = new HashMap<>();

            for (int j = i + 1; j < arr.length; j++) {

                int required = -(arr[i] + arr[j]);

                if (map.containsKey(required)) {
                    for (int k : map.get(required)) {
                        ans.add(Arrays.asList(i, k, j));
                    }
                }

                map.computeIfAbsent(arr[j], x -> new ArrayList<>()).add(j);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution obj = new Solution();

        List<List<Integer>> result = obj.findTriplets(arr);

        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }

        sc.close();
    }
}
