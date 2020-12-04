package LeetCode;

import org.junit.Test;

/**
 * @description: 制造字母异位词的最小步骤数
 * @author: wang hao
 * @create: 2020-11-25 09:29
 */
public class _1347 {
    public int minSteps(String s, String t) {
        int[] count1 = new int[26];
        for (char c : s.toCharArray()) {
            count1[c - 'a']++;
        }
        int[] count2 = new int[26];
        for (char c : t.toCharArray()) {
            count2[c - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (count2[i] < count1[i]) {
                res += (count1[i] - count2[i]);
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(minSteps("leetcode", "practice"));
    }
}
