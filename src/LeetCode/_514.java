package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 自由之路
 * @author: wang hao
 * @create: 2020-11-11 08:57
 */
public class _514 {
    public int findRotateSteps(String ring, String key) {
        int m = key.length(), n = ring.length();
        int[][] dp = new int[m][n];
        // 维护ring中每个字母出现的位置
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 0x3f3f3f);
        }
        // 初始位置
        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}
