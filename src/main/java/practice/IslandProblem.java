package practice;

import java.util.ArrayDeque;
import java.util.Queue;

public class IslandProblem {

    // Below arrays details all 8 possible movements from a cell
    // (top, right, bottom, left)
    private static final int[] row = {-1, 0, 0, 1};
    private static final int[] col = {0, -1, 1, 0};

    public static void main(String[] args) {
        int[][] mat=
                {
                        { 1, 0, 1, 0, 0, 0, 1, 1, 1, 1 },
                        { 0, 0, 1, 0, 1, 0, 1, 0, 0, 0 },
                        { 1, 1, 1, 1, 0, 0, 1, 0, 0, 0 },
                        { 1, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
                        { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
                        { 0, 1, 0, 1, 0, 0, 1, 1, 1, 1 },
                        { 0, 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 1, 0, 0, 1, 1, 1, 0 },
                        { 1, 0, 1, 0, 1, 0, 0, 1, 0, 0 },
                        { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 }
                };
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int count = 0;
        boolean processed[][] = new boolean[M][N];
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (grid[i][j]!='0' && processed[i][j]==false){
                    BFS(grid,i, j, processed);
                    count++;
                }
            }

        }
        return count;
    }

    public static boolean isSafe(char[][]grid, int x, int y, boolean processed[][]){
        return (x >= 0) && (x < processed.length) &&
                (y >= 0) && (y < processed[0].length) &&
                (grid[x][y] == '1' && !processed[x][y]);
    }

    private static void BFS(char[][] grid, int i, int j, boolean[][] processed) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(i, j));

        processed[i][j] = true;
        while (!queue.isEmpty()) {
            // pop front node from queue and process it
            int x = queue.peek().x;
            int y = queue.peek().y;
            queue.poll();

            // check for all 8 possible movements from current cell
            // and enqueue each valid movement
            for (int k = 0; k < 4; k++)
            {
                // Skip if location is invalid or already processed
                // or has water
                if (isSafe(grid, x + row[k], y + col[k], processed))
                {
                    // skip if location is invalid or it is already
                    // processed or consists of water
                    processed[x + row[k]][y + col[k]] = true;
                    queue.add(new Pair(x + row[k], y + col[k]));
                }
            }
        }
    }
}

class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
