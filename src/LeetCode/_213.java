package LeetCode;

import java.util.Arrays;

/**
 * @program: data-structure
 * @description: 打家劫舍 II
 * @author: wang hao
 * @create: 2020-05-29 09:56
 */
public class _213 {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     */

    //偷第一间房就不能偷最后一件房，对应的下标为0,n-2
    //不偷第一间房就可以偷最后一间房，对应的下标为1,n-1
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(dp(Arrays.copyOfRange(nums, 0, nums.length - 1)), dp(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int dp(int[] arr) {
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        _213 t = new _213();
        int rob = t.rob(new int[]{1, 2, 3, 1});
        System.out.println(rob);

    }
}
