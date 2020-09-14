package LeetCode;

/**
 * @description: 最长有序括号
 * @author: wang hao
 * @create: 2020-09-14 15:03
 */
public class _32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        //dp[i]代表以i为结尾的字符串可以组成的最长有效括号的长度
        int[] dp = new int[s.length()];
        int res = 0;
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '(' && s.charAt(i) == ')') dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            if (s.charAt(i - 1) == ')' && s.charAt(i) == ')' && i - dp[i - 1] >= 1 && s.charAt(i - dp[i - 1] - 1) == '(')
                dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
