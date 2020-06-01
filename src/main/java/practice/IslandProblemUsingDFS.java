package practice;

public class IslandProblemUsingDFS {
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
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
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
                    DFS(grid,i, j, processed);
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

    private static void DFS(char[][] grid, int i, int j, boolean[][] processed) {

        processed[i][j] = true;

            // check for all 8 possible movements from current cell
            // and enqueue each valid movement
            for (int k = 0; k < 4; k++)
            {
                // Skip if location is invalid or already processed
                // or has water
                if (isSafe(grid, i + row[k], j + col[k], processed))
                {
                    // skip if location is invalid or it is already
                    DFS(grid,i + row[k], j + col[k], processed);
                }
            }
        }

}


