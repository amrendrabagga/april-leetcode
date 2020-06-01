package practice;

import java.util.Arrays;

public class LeftMostColumn2 {
    public static void main(String[] args) {
        int arr[][] = {{0,0}, {0,1}};
        System.out.println(leftMostColumnWithOne(arr));
//        System.out.println(duplicateBinarySearch(new int[] {1,1}));
    }
    public static int leftMostColumnWithOne(int[][] binaryMatrix) {
//        List<Integer> list = binaryMatrix.dimensions();
        int arrOfStartingIndexRowWise[] = new int[binaryMatrix.length];
        Arrays.fill(arrOfStartingIndexRowWise, -1);
        int min = Integer.MAX_VALUE;
        int M = binaryMatrix.length;
        int N = binaryMatrix[0].length;
        int index = -1;

        for (int i=0; i<M; i++) {// O(n)
            int firstOccurence = duplicateBinarySearch(binaryMatrix[i]);
            arrOfStartingIndexRowWise[i] = firstOccurence;
        }

        for (int j=0; j<N; j++) {
            int count = 0;
            for (int i=0; i<M; i++) {
                // check first occurence of each row
                // if that is smaller than j ie arrOfStartingIndexRowWise[i] < j
                if (arrOfStartingIndexRowWise[i]!=-1 && arrOfStartingIndexRowWise[i]<= j)
                    count++;
            }
            if (count !=0 && count < min){
                min = count;
                index = j;
            }
        }
        return index;
    }

    private static int duplicateBinarySearch(int[] binaryMatrix) {
        int low = 0;
        int high = binaryMatrix.length-1;
        while (low<=high) {
            int mid = (low + high) / 2;
            if (binaryMatrix[mid] == 1 && (mid == 0 || binaryMatrix[mid-1]==0))
                return mid;
            if (binaryMatrix[mid]==1)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }

}
