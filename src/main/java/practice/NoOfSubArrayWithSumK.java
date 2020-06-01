package practice;

import java.util.HashMap;
import java.util.Map;

public class NoOfSubArrayWithSumK {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }
    public static int subarraySum(int[] nums, int k) {
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            currSum += nums[i];
            if (currSum == k)
                count++;
            if (map.containsKey(currSum - k))
                count += map.get(currSum - k);
            map.compute(currSum, (p,v)-> v == null ? 1 : v+1);
        }
        return count;
    }
}
