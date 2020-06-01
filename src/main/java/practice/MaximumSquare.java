package practice;

public class MaximumSquare {
    public static void main(String[] args) {

        System.out.println(calculateMin(23,54656,12));
        char [][]matrix = {
                {'0','0','1','0'},
                {'1','1','1','1'},
                {'1','1','1','1'},
                {'1','1','1','0'},
                {'1','1','0','0'},
                {'1','1','1','1'},
                {'1','1','1','0'}
        };
        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {

        if (matrix.length==0)
            return 0;
        int dp[][] = new int[matrix.length+1][matrix[0].length+1];

        // fill top and leftmost column with zero
        for (int i=0;i<=matrix[0].length;i++)
            dp[0][i] = 0;

        for (int i=0;i<=matrix.length;i++)
            dp[i][0] = 0;

        int largest = Integer.MIN_VALUE;
        for (int i=1;i<=matrix.length;i++) {
            for (int j=1;j<=matrix[0].length;j++) {
                if (matrix[i-1][j-1] == '1') {
                    int squareLength = 1 + calculateMin(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]);
                    dp[i][j] = squareLength;
                    if (largest < squareLength)
                        largest = squareLength;
                }
            }
        }
        return largest*largest;
    }

    private static int calculateMin(int a, int b, int c) {
        return a > b ? b > c ? c : b : c > a ? a : c;
    }
}
