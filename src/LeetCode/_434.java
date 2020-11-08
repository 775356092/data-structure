package LeetCode;

import org.junit.Test;

/**
 * @description: 字符串中的单词数
 * @author: wang hao
 * @create: 2020-11-03 09:12
 */
public class _434 {
    public int countSegments(String s) {
        //s = s.trim();
        //if (s.length() == 0) return 0;
        //return s.split("\\s+").length;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                res++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }
}
