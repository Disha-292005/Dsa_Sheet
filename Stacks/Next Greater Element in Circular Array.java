import java.util.*;

public class Main {

    public static ArrayList<Integer> nextGreater(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        int n = arr.length;

        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n;

            while (!st.isEmpty() && st.peek() <= arr[index]) {
                st.pop();
            }

            if (i < n) {
                if (st.isEmpty()) {
                    ans.add(-1);
                } else {
                    ans.add(st.peek());
                }
            }

            st.push(arr[index]);
        }

        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> result = nextGreater(arr);

        System.out.println(result);

        sc.close();
    }
}
