import java.util.*;

class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        Queue<int[]> q = new LinkedList<>();

        int n = image.length;
        int m = image[0].length;

        int original = image[sr][sc];

        // Already the required color
        if (original == newColor) {
            return image;
        }

        q.offer(new int[]{sr, sc});

        // Mark as visited by changing the color
        image[sr][sc] = newColor;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!q.isEmpty()) {

            int[] current = q.poll();

            int r = current[0];
            int c = current[1];

            for (int[] d : directions) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    image[nr][nc] == original) {

                    image[nr][nc] = newColor;

                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return image;
    }
}

public class Main {

    public static void main(String[] args) {

        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1;
        int sc = 1;
        int newColor = 2;

        Solution obj = new Solution();

        int[][] result = obj.floodFill(image, sr, sc, newColor);

        for (int i = 0; i < result.length; i++) {

            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }
    }
}
