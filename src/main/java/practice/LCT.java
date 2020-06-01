package practice;

import java.util.HashMap;

public class LCT {
    public static void main(String[] args) {
        int arr[] = new int[]{0,1,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,1,0,1,0,1,0,1,0,1};
    }

    private static int getLCT(int[] nums) {
        for (int i=0;i<nums.length;i++) {
            nums[i] = nums[i] > 0 ? 1 : -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (sum == 0)
                max = 1 + i;
            if (map.containsKey(sum)) {
                if (max < i - map.get(sum))
                    max = i - map.get(sum);
            }
            else map.put(sum, i);
        }
        return max;
    }
}
