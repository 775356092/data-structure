package LeetCode;

/**
 * @description: 买卖股票的最佳时机
 * @author: wang hao
 * @create: 2020-09-18 17:35
 */
public class _121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[2][prices.length];
        //dp[0][i] 没股票
        //dp[1][i] 有股票
        dp[1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i]);//之前卖的，或者今天卖的
            dp[1][i] = Math.max(dp[1][i - 1], -prices[i]);//之前买的，或者今天买的
        }
        return dp[0][prices.length - 1];
    }
}
