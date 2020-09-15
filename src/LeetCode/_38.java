package LeetCode;

import org.junit.Test;

/**
 * @description: 外观数列
 * @author: wang hao
 * @create: 2020-09-09 14:06
 */
public class _38 {
    public String countAndSay(int n) {
        String[] dp = new String[n + 1];
        dp[1] = "1";
        for (int i = 2; i <= n; i++) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            char[] s = dp[i - 1].toCharArray();
            for (int j = 0; j < s.length - 1; j++) {
                if (s[j] == s[j + 1]) {
                    count++;
                    continue;
                }
                sb.append(count).append(s[j]);
                count = 1;
            }
            sb.append(count).append(s[s.length - 1]);
            dp[i] = sb.toString();
        }
        return dp[n];
    }

    @Test
    public void test(){
        System.out.println(countAndSay(4));
    }
}
