import java.util.*;

class Solution {

    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();

        helper(0, 0, arr, ans);

        return ans;
    }

    void helper(int i, int res, int[] arr, ArrayList<Integer> ans) {

        if (i == arr.length) {
            ans.add(res);
            return;
        }

        // Include current element
        helper(i + 1, res + arr[i], arr, ans);

        // Exclude current element
        helper(i + 1, res, arr, ans);
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

        ArrayList<Integer> ans = obj.subsetSums(arr);

        System.out.println("Subset sums:");
        System.out.println(ans);

        sc.close();
    }
}
