package practice;

public class Continous01SubArray {
    public static void main(String[] args) {
//        System.out.println((1^0) == 0);
        System.out.println(findMaxSubArray(new int[]{1,0,1}));
    }

    private static int findMaxSubArray(int[] nums) {
        if (nums.length<2) return 0;
        int tmp[] = new int[nums.length];
        tmp[0] = 0;
        if ((nums[0]^nums[1]) == 0)
            tmp[1] = 1;

        for (int i=2; i<nums.length; i++) {
            if ((nums[i]^nums[i-1])==0 && nums[i]==nums[i-2] && i%2==0)
                tmp[i] = tmp[i-2] + 1;

        }
        return -1;
    }
}
