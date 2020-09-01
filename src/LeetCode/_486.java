package LeetCode;

/**
 * @description: 预测赢家
 * @author: wang hao
 * @create: 2020-09-01 08:57
 */
public class _486 {
    //dp[i][j] 代表净胜分
    //dp[i][j] = Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1])
public boolean PredictTheWinner(int[] nums) {
    int n = nums.length;
    int[][] dp = new int[n][n];
    //i==j 代表数组中只有一个数，净胜分就为nums[i]
    for (int i = 0; i < n; i++) {
        dp[i][i] = nums[i];
    }
    //数组构建顺序：从下往上，从左往右
    for (int i = n - 2; i >= 0; i--) {
        for (int j = i + 1; j < n; j++) {
            dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
        }
    }
    return dp[0][n - 1] >= 0;
}
}
