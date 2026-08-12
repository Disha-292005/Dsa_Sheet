import java.util.*;

class Solution {

    public int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int low = 0;
        int high = 0;
        int maxLen = -1;

        while (high < fruits.length) {

            // Add current fruit
            map.put(fruits[high],
                    map.getOrDefault(fruits[high], 0) + 1);

            // More than 2 types of fruits
            while (map.size() > 2) {

                map.put(fruits[low],
                        map.get(fruits[low]) - 1);

                if (map.get(fruits[low]) == 0) {
                    map.remove(fruits[low]);
                }

                low++;
            }

            // Valid window with at most 2 types
            maxLen = Math.max(maxLen, high - low + 1);

            high++;
        }

        return maxLen;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] fruits = new int[n];

        System.out.println("Enter fruit types:");

        for (int i = 0; i < n; i++) {
            fruits[i] = sc.nextInt();
        }

        Solution obj = new Solution();

        int result = obj.totalFruit(fruits);

        System.out.println("Maximum fruits collected: " + result);

        sc.close();
    }
}
