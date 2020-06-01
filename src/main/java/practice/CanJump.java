package practice;

public class CanJump {
    public static void main(String[] args) {

    }

    public static boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i=0; i<nums.length; i++) {
            if (i > reachable)
                return false;
            reachable = Math.max(reachable, nums[i] + i);
        }
        return true;
    }
}