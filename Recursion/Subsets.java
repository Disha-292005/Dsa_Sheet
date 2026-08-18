import java.util.*;

class Solution {

    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        helper(0, arr, res, ans);

        return ans;
    }

    void helper(int i, int[] arr, ArrayList<Integer> res,
                ArrayList<ArrayList<Integer>> ans) {

        if (i == arr.length) {
            ans.add(new ArrayList<>(res));
            return;
        }

        // Include current element
        res.add(arr[i]);
        helper(i + 1, arr, res, ans);

        // Backtrack
        res.remove(res.size() - 1);

        // Exclude current element
        helper(i + 1, arr, res, ans);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution obj = new Solution();

        ArrayList<ArrayList<Integer>> ans = obj.subsets(arr);

        System.out.println("All subsets:");

        for (ArrayList<Integer> subset : ans) {
            System.out.println(subset);
        }

        sc.close();
    }
}
