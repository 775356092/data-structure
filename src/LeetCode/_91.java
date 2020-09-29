package LeetCode;

/**
 * @description: 解码方法
 * @author: wang hao
 * @create: 2020-09-28 16:55
 */
public class _91 {
    public int numDecodings(String s) {
        char[] t = s.toCharArray();
        // 如果第一个字符为0，直接返回0
        if (s.charAt(0) == '0') return 0;
        // dp[i]表示多少种解法
        int[] dp = new int[s.length() + 1];
        // 从最后一个字符看，如果最后一个字符单独解码(只有一种)
        // 根据排列组合中的乘法原理,dp[i-1]*1种，如果最后一个字符和第i-1个字符联合解码，也只有一种，dp[i-2]*1
        // 合起来就是dp[i] = dp[i-1] + dp[i-2]
        dp[0] = dp[1] = 1;
        // 如果s[i]=0, 必须s[i-1] == 1 || s[i-1] == 2, dp[i] = dp[i-2], 否则直接返回0;
        // s[i-1] == 1, dp[i] = dp[i-1] + dp[i-2];
        // s[i-1] == 2, 1<=s[i]<=6, dp[i-1] + dp[i-2]
        for (int i = 1; i < s.length(); i++) {
            if (t[i] == '0') {
                if (t[i - 1] == '1' || t[i - 1] == '2') {
                    dp[i + 1] = dp[i - 1];
                } else {
                    return 0;
                }
            } else {
                if (t[i - 1] == '1' || (t[i - 1] == '2' && t[i] <= '6' && t[i] >= '1')) {
                    dp[i + 1] = dp[i - 1] + dp[i];
                } else {
                    dp[i + 1] = dp[i];
                }
            }
        }
        return dp[s.length()];
    }
}
