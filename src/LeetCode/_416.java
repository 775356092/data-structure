package LeetCode;

import org.junit.Test;

/**
 * @description: 分割等和子集
 * @author: wang hao
 * @create: 2020-10-12 10:25
 */
public class _416 {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        if (n < 2) return false;
        for (int num : nums) {
            sum += num;
        }
        // 奇数
        if ((sum & 1) == 1) return false;
        int t = sum >> 1;
        boolean[][] dp = new boolean[n][t + 1];
        if (t >= nums[0]) dp[0][nums[0]] = true;
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= t; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][t];
    }

    @Test
    public void test() {
        System.out.println(canPartition(new int[]{9, 5}));
    }
}
