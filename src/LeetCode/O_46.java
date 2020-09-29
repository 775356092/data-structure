package LeetCode;

/**
 * @description: 把数字翻译成字符串
 * @author: wang hao
 * @create: 2020-09-29 13:38
 */
public class O_46 {
    public int translateNum(int num) {
        char[] s = Integer.toString(num).toCharArray();
        int[] dp = new int[s.length + 1];
        dp[0] = dp[1] = 1;
        // 0<=s[i - 1]s[i] <= 25, dp[i] = dp[i - 2] + dp[i - 1]
        for (int i = 1; i < s.length; i++) {
            int t = (s[i - 1] - '0') * 10 + (s[i] - '0');
            if (t >= 10 && t <= 25) dp[i + 1] = dp[i - 1] + dp[i];
            else dp[i + 1] = dp[i];
        }
        return dp[s.length];
    }
}
