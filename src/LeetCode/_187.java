package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 重复的DNA序列
 * @author: wang hao
 * @create: 2020-10-21 13:44
 */
public class _187 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String t = s.substring(i, i + 10);
            if (set.contains(t)) {
                set2.add(t);
            } else {
                set.add(t);
            }
        }
        return new ArrayList<>(set2);
    }
    @Test
    public void test() {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}
