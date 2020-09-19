package LeetCode;

/**
 * @description: 跳跃游戏
 * @author: wang hao
 * @create: 2020-09-15 13:29
 */
public class _55 {
    public boolean canJump(int[] nums) {
        int max = 0;//每次更新可以跳到最远的距离
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
            }
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
