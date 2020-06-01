package practice;

public class ShortestPathEndToEndInMatrix {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        //[[1,6,1],[1,5,1],[4,3,1]]
        int[][] mat=
                {
                        {1,6,1},
                        {1,5,1},
                        {4,3,1}
                };
        int test[][] = {
                {1}
        };
        System.out.println(minPathSum(test));
    }
    public static int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        boolean processed[][] = new boolean[M][N];
        DFS(grid, processed, 0, 0, grid[0][0]);
        return min;
    }

    private static void DFS(int[][] grid, boolean[][] processed, int i, int j, int sum) {

        if (i==grid.length-1 && j==grid[0].length-1)
            //compare sum to get min
            if (sum < min)
                min = sum;

        processed[i][j] = true;
        if (isSafe(processed, i+1,j))
            DFS(grid, processed, i+1, j, sum + grid[i+1][j]);
        if (isSafe(processed,i, j+1))
            DFS(grid, processed, i, j+1, sum + grid[i][j+1]);

        processed[i][j] = false;
    }

    private static boolean isSafe(boolean[][] processed, int i, int j) {
        return i>=0 && j>=0 && i < processed.length && j < processed[0].length && processed[i][j]!=true;
    }
}
