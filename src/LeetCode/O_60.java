package LeetCode;

/**
 * @program: data-structure
 * @description: n个骰子的点数
 * @author: wang hao
 * @create: 2020-05-22 10:54
 */
public class O_60 {
    /**
     * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
     * <p>
     * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
     */
    public double[] twoSum(int n) {
        //初始化dp数组，dp[n][s]代表骰子数位n，和为s的情况数量
        //dp[n][s]=dp[n-1][]
        double dp[][] = new double[n + 1][6 * n + 1];
        double res[] = new double[5 * n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                if (i == 1) {
                    dp[i][j] = 1;
                    continue;
                }
                for (int k = 1; k <= 6; k++) {
                    if (j - k >= i - 1) dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        for (int i = n; i <= 6 * n; i++) {
            res[i - n] = (dp[n][i]) / Math.pow(6, n);
        }
        return res;
    }
}
