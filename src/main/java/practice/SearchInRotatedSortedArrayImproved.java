package practice;

public class SearchInRotatedSortedArrayImproved {
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int test[] = {8,9,1,2,3,4,5,6};
        System.out.println(search(new int[] {1}, 4));
//        System.out.println(search(arr,6));
    }
    public static int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        return singleParsedBinarySearch(nums, target, 0, nums.length-1);
    }

    private static int singleParsedBinarySearch(int[] nums, int target, int l, int r) {
        if (l > r) return -1;
        int mid = (l + r)/2;

        if (nums[mid] == target)
            return mid;
        // check if left array is sorted
        if (nums[mid] >= nums[l]) {
            // check if key is present in this subarray
            if (target<= nums[mid] && target>= nums[l])
                return singleParsedBinarySearch(nums, target, l, mid-1);
            else // left subarray sorted still element not present here must be in right one
                return singleParsedBinarySearch(nums, target, mid+1, r);
        }

        if (target<=nums[r] && target>=nums[mid+1])
            return singleParsedBinarySearch(nums, target, mid+1, r);
        return singleParsedBinarySearch(nums, target, l, mid-1);
    }
}
