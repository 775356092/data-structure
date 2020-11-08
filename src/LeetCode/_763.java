package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 划分字母区间
 * @author: wang hao
 * @create: 2020-10-22 09:16
 */
public class _763 {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] last = new int[26];
        //每个字母最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        while (start < s.length()) {
            int end = last[s.charAt(start) - 'a'];
            for (int i = start + 1; i < end; i++) {
                int j = last[s.charAt(i) - 'a'];
                if (j > end) {
                    end = j;
                }
            }
            res.add(end - start + 1);
            start = end + 1;
        }
        return res;
    }
    @Test
    public void test() {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
