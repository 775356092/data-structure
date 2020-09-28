package LeetCode;

/**
 * @description: 丑数 II
 * @author: wang hao
 * @create: 2020-09-28 10:10
 */
public class _264 {
    public int nthUglyNumber(int n) {
        int i2 = 1, i3 = 1, i5 = 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if (dp[i] == dp[i2] * 2) i2++;
            if (dp[i] == dp[i3] * 3) i3++;
            if (dp[i] == dp[i5] * 5) i5++;
        }
        return dp[n];
    }
}
