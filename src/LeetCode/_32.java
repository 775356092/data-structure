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
            //如果当前字符为'(', dp[i] = 0, 有效括号不可能以'('为结尾
            //如果当前字符为')', 并且前一个字符等于'(', 那么这两个字符可以组成一对有效括号, ...(), dp[i] = dp[i-2] + 2
            if (s.charAt(i - 1) == '(' && s.charAt(i) == ')') dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            //如果当前字符为')', 并且前一个字符等于')', 那么要分情况讨论了
            //有可能是这样的格式 ...((...)), 其中(...)代表dp[i-1], 它的上一个字符的下标是i-dp[i-1]-1
            //如果dp[i-1]的上一个字符是')',那么dp[i] = 0; 如果dp[i-1]的上一个字符是'(', dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
            if (s.charAt(i - 1) == ')' && s.charAt(i) == ')' && i - dp[i - 1] >= 1 && s.charAt(i - dp[i - 1] - 1) == '(')
                dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
