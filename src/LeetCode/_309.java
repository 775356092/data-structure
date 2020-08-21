package LeetCode;

/**
 * @description: 最佳买卖股票时机含冷冻期
 * @author: wang hao
 * @create: 2020-07-10 16:53
 */
public class _309 {
    /**
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
     * <p>
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * <p>
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     */

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        /**
         * 股票有多少种状态变化呢？
         * 1. 手上没股票 是因为啥也没干 dp[i][0]
         * 2. 手上有股票 是因为有可能我今天买的，也有可能是之前买的 dp[i][1]
         * 3. 手上没股票 是因为当天卖了 dp[i][2]
         */
        int[][] dp = new int[prices.length + 1][3];
        dp[0][0] = 0; //第一天没买
        dp[0][1] = -1 * prices[0]; //第一天买了
        dp[0][2] = 0; //啥也没干

        /**
         * dp[i][0] = ?
         * 有可能我昨天卖了dp[i][0] = dp[i-1][2]
         * 有可能昨天我手上没股票，啥也没干 dp[i][0] = dp[i-1][0]
         * 所以 dp[i][0] = max{dp[i-1][2], dp[i-1][0]}
         */

        /**
         * dp[i][1] = ?
         * 有可能是我昨天买的 dp[i][1] = dp[i-1][1]
         * 有可能是我今天才买的，但是我昨天一定没有卖股票，并且我昨天手上也没有股票 dp[i][1] = dp[i-1][0] - price[i]
         * 所以 dp[i][1] = max{dp[i-1][1], dp[i-1][0] - price[i]}
         */

        /**
         * dp[i][2] = ?
         * 今天卖了，所以我昨天手上一定有股票 dp[i][2] = dp[i-1][1] + price[i]
         */

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][2], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        /**
         * 题解是求最后一天的最大利益，最后一天的最大利益只可能是手上没有股票
         */
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }
}
