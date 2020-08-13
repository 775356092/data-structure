package LeeCode;

/**
 * @description: 整数拆分
 * @author: wang hao
 * @create: 2020-07-30 08:59
 */
public class _343 {

    /**
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     */

    public static long integerBreak(int n) {
        long[] dp = new long[n+1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            long temp = 0;
            for (int j = 1; j < i; j++) {
                temp = Math.max(temp, Math.max(j * (i - j), dp[i - j] * j));
            }
            dp[i] = temp;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        long past = System.currentTimeMillis();
        System.out.println(integerBreak(10000));
        long curr = System.currentTimeMillis();
        System.out.println(curr-past);
    }
}
