package LeetCode;

/**
 * @description: 正则表达式匹配
 * @author: wang hao
 * @create: 2020-09-08 11:22
 */
public class _10 {

    public boolean isMatch(String s, String p) {
        //表示s的前i个字符和p的前i个字符是否匹配
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //s为空，p不为空，想要匹配的话必须要求右端是'*'，dp[0][j] = dp[0][j-2], 如果p[j-1] != '*', dp[0][j] = false;
        //s为空，p为空，肯定匹配，dp[0][0] = true
        //s不为空，p为空，肯定不匹配，dp[i][0] = false

        //如果s[i-1] == p[j-1] || p[j-1] == '.', dp[i][j] = dp[i-1][j-1] （如果末尾字符匹配）
        //如果s[i-1] != p[j-1] && p[j-1] != '*', dp[i][j] = false (如果末尾字符不匹配，并且p的末尾不是'*')
        //如果s[i-1] != p[j-1] && p[j-1] == '*', 如果s[i-2] == p[j-2] || p[j-2] = '.'，分三种情况：
        //  -如果让p[j-2]重复0次，dp[i][j] = dp[i][j-2],（这里理解为，p的末端两个字符没用，可以看前面的了）
        //  -如果让p[j-2]重复1次，dp[i][j] = dp[i-1][j-2],（这里理解为，s的末端一个字符和p的末端两个字符匹配上了，可以看前面的了）
        //  -如果让p[j-2]重复2次以上，dp[i][j] = dp[i-1][j],(这里理解为，s的末端一个字符和p的末端n个字符匹配上了，但是p的末端仍可以看成是.*的结构)
        //如果s[i-1] != p[j-1] && p[j-1] == '*', 如果s[i-2]和p[j-2]不匹配，让p[j-2]重复0次，dp[i][j] = dp[i][j-2]

        dp[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                //s[i-1]和p[j-1]是否匹配
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    //s[i-1]和p[j-2]是否匹配
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
