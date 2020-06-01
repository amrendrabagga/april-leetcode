package practice;


public class MinimumPathSumDynamic {
    public static void main(String[] args) {
        int[][] mat=
                {
                        {1,6,1},
                        {1,5,1},
                        {4,3,1}
                };
        System.out.println(minPathSum(mat));
    }
    public static int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int dp[][] = new int[M][N];
        // set top col
        dp[0][0] = grid[0][0];
        for (int i=1;i<N;i++) {
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }

        // set left col
        for (int i=1; i<M; i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for (int i=1; i<M; i++) {
            for (int j=1; j<N; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }

        }
        return dp[M-1][N-1];

    }

}
