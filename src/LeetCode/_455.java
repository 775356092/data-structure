package LeetCode;

import java.util.Arrays;

/**
 * @description: 分发饼干
 * @author: wang hao
 * @create: 2020-11-27 11:02
 */
public class _455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int j = 0;
        for (int i = 0; i < g.length; i++) {
            while (j < s.length && s[j] < g[i]) {
                j++;
            }
            if (j == s.length) return res;
            res++;
            j++;
        }
        return res;
    }
}
