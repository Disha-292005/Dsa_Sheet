import java.util.*;

class Solution {

    public ArrayList<String> ratInMaze(int[][] maze) {

        ArrayList<String> ans = new ArrayList<>();

        int n = maze.length;

        if (n == 0 || maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return ans;
        }

        boolean[][] visited = new boolean[n][n];

        solve(0, 0, n, maze, visited, "", ans);

        return ans;
    }

    void solve(int i, int j, int n, int[][] maze,
               boolean[][] visited, String path,
               ArrayList<String> ans) {

        // Destination reached
        if (i == n - 1 && j == n - 1) {
            ans.add(path);
            return;
        }

        visited[i][j] = true;

        // Down
        if (i + 1 < n &&
            maze[i + 1][j] == 1 &&
            !visited[i + 1][j]) {

            solve(i + 1, j, n, maze, visited, path + 'D', ans);
        }

        // Left
        if (j - 1 >= 0 &&
            maze[i][j - 1] == 1 &&
            !visited[i][j - 1]) {

            solve(i, j - 1, n, maze, visited, path + 'L', ans);
        }

        // Right
        if (j + 1 < n &&
            maze[i][j + 1] == 1 &&
            !visited[i][j + 1]) {

            solve(i, j + 1, n, maze, visited, path + 'R', ans);
        }

        // Up
        if (i - 1 >= 0 &&
            maze[i - 1][j] == 1 &&
            !visited[i - 1][j]) {

            solve(i - 1, j, n, maze, visited, path + 'U', ans);
        }

        // Backtracking
        visited[i][j] = false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[][] maze = new int[n][n];

        System.out.println("Enter the maze:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        Solution obj = new Solution();

        ArrayList<String> ans = obj.ratInMaze(maze);

        if (ans.isEmpty()) {
            System.out.println("No path exists.");
        } else {
            System.out.println("Possible paths:");

            for (String path : ans) {
                System.out.println(path);
            }
        }

        sc.close();
    }
}
