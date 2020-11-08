package LeetCode;

/**
 * @description: 最长上升子序列
 * @author: wang hao
 * @create: 2020-10-22 15:16
 */
public class _300 {
    // 动态规划 O(n^2)
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        // 以nums[i]为结尾的最长上升子序列的长度
        int[] dp = new int[nums.length];
        int res = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
