package LeetCode;

import org.junit.Test;

/**
 * @description: 完全平方数
 * @author: wang hao
 * @create: 2020-10-23 15:55
 */
public class _279 {
    // 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
    @Test
    public void test() {
        System.out.println(numSquares(13));
    }
}
