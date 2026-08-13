import java.util.*;

class Solution {

    ArrayList<Integer> removeDuplicates(int[] arr) {
        int j = 0;

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }

        for (int i = 0; i <= j; i++) {
            ans.add(arr[i]);
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

        ArrayList<Integer> result = obj.removeDuplicates(arr);

        for (int x : result) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}
