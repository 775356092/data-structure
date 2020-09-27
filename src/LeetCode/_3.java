package LeetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: data-structure
 * @description: 无重复字符的最长子串
 * @author: wang hao
 * @create: 2020-05-26 17:47
 */
public class _3 {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     */
    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int res = 1;
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    res++;
                } else {
                    break;
                }
            }
            ans = Math.max(res, ans);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] lefts = new int[128];
        Arrays.fill(lefts, -1);
        int res = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            //字符串内字符不能重复，所以要从上一次出现位置的下一个位置开始
            left = Math.max(left, lefts[s.charAt(i)] + 1);
            lefts[s.charAt(i)] = i;
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring2("abcaa"));
    }
}
