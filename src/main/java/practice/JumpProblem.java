package practice;

import java.util.Arrays;

public class JumpProblem {
    public static void main(String[] args) {
//        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{0,2,3}));
    }
    public static boolean canJump(int[] nums) {
        int minJumps[] = new int[nums.length];
        Arrays.fill(minJumps, Integer.MAX_VALUE);
        minJumps[0] = 0;

        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (j + nums[j] >= i) {
                    int jump = minJumps[j] + 1;
                    minJumps[i] = Math.min(jump, minJumps[i]);
                }
            }
        }
        System.out.println(Arrays.toString(minJumps));
        return (minJumps[nums.length-1] < 0 || minJumps[nums.length-1] == Integer.MAX_VALUE) ? false: true;
    }
}
