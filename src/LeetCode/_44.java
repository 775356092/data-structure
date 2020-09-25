package LeetCode;

/**
 * @description: 通配符匹配
 * @author: wang hao
 * @create: 2020-09-25 12:53
 */
public class _44 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //s为空，p为空，肯定匹配，dp[0][0] = true
        //s为空，p不为空，想要匹配的话要求p只能有'*'
        //s不为空，p为空，肯定不匹配，dp[i][0] = false
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        //s[i-1] == p[j-1], 或者p[j-1] == '?', dp[i][j] = dp[i-1][j-1]
        //p[j-1] == '*', 它可以匹配多个，也可以不匹配
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
