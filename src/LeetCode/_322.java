package LeetCode;

import java.util.Arrays;

/**
 * @description: 零钱兑换
 * @author: wang hao
 * @create: 2020-11-13 17:04
 */
public class _322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 105);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > 104 ? -1 : dp[amount];
    }
}
