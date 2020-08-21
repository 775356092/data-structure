package LeetCode;

/**
 * @description: 回文子串
 * @author: wang hao
 * @create: 2020-08-19 08:56
 */
public class _647 {
    /**
     * 动态规划：
     * 根据动态规划的思想，我们定义dp[i][j],i和j分别指向字符串的两端，dp[i][j]就是判断当前字符串是否为回文字符串
     * 那么如何推出状态转移方程呢？ 当一个字符串为奇数的时候，我们只需要判断dp[i+1][j-1]是否为回文字符串
     * 当且仅当s[i]==s[j]时，s[i]==s[j] && dp[i+1][j-1] 为true时，dp[i][j] = true
     * 特殊情况，i==j时，即一个字符，必定是回文字符串；当j=i+1时，即两个字符，如果两个字符相等则是回文字符串
     *
     * @param s
     * @return
     */
public int countSubstrings(String s) {
    if (s == null || s.equals("")) {
        return 0;
    }
    int res = 0;
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int j = 0; j < s.length(); j++) {
        for (int i = 0; i <= j; i++) {
            if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                dp[i][j] = true;
                res++;
            }
        }
    }
    return res;
}

    /**
     * 拓展中心法
     * 当一个回文字符串长度为奇数时，我们可以看作是以一个中心字符向两端不断扩展的过程，比如ababa，中心点为a
     * 当一个回文字符串长度为偶数时，我们可以看作是以两个中心字符向两端不断扩展的过程，比如abba，中心点为bb
     * <p>
     * 以ababa字符串为例，我们可以列举出所有的中心点，a,b,a,b,a,ab,ba,ab,ba 一共有9个，可以发现中心点的个数为len*2-1
     *
     * @param s
     * @return
     */
    public int countSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int res = 0;
        for (int center = 0; center < s.length() * 2 - 1; center++) {
            int left = center / 2;
            //center为偶数代表一个中心字符，right = left; center为奇数代表两个中心字符，right = left + 1
            int right = left + center % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                res++;
                left--;
                right++;
            }
        }
        return res;
    }


}
