package practice;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int test[] = {8,9,1,2,3,4,5,6};
        System.out.println(search(new int[] {1}, 1));
//        System.out.println(search(arr,6));
    }
    public static int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        // search pivot
        int pivot = pivotSearch(nums);

        // binary search in left or right
        if (nums[nums.length-1] < target)
            return binarySearch(nums, target, 0, pivot);
        else
            return binarySearch(nums, target, pivot+1, nums.length-1);
    }

    private static int binarySearch(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int mid = (l + r)/2;
            if (nums[mid] == target)
                return mid;
            if (target < nums[mid])
                r = mid;
            else l = mid;
        }
        return -1;
    }

    private static int pivotSearch(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while (l <= r) {
            int mid = (l + r)/2;
            if (nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1])
                return mid;
            if (nums[mid] < nums[r])// sorted ahead so go in opposite direction
                r = mid;
            else l = mid;
        }
        return -1;
    }
}
