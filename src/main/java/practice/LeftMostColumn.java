package practice;

public class LeftMostColumn {
    public static void main(String[] args) {
        int arr[][] = {{0,0}, {0,1}};
        System.out.println(leftMostColumnWithOne(arr));
    }
    public static int leftMostColumnWithOne(int[][] binaryMatrix) {
//        List<Integer> list = binaryMatrix.dimensions();
//        int arrOfStartingIndexRowWise[] = new int[binaryMatrix.length];
        int min = Integer.MAX_VALUE;
        int M = binaryMatrix.length;
        int N = binaryMatrix[0].length;
        int index = -1;

        for (int j=0; j<N; j++) {
            int count = 0;
            for (int i=0; i<M; i++) {
                if (binaryMatrix[i][j] == 1) {
                    count++;
                    if (min != Integer.MAX_VALUE && count > min) {
                        break;
                    }
                }
            }
            if (count !=0 && count < min){
                min = count;
                index = j;
            }
        }
        return index;
    }
}
