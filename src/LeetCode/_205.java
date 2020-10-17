package LeetCode;

import org.junit.Test;

import java.util.HashMap;

/**
 * @description: 同构字符串
 * @author: wang hao
 * @create: 2020-10-16 13:49
 */
public class _205 {
    public boolean isIsomorphic(String s, String t) {
        return cal(new HashMap<>(), s).equals(cal(new HashMap<>(), t));
    }

    public String cal(HashMap<Character, Integer> map, String s) {
        StringBuilder sb = new StringBuilder();
        int t = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                sb.append(map.get(s.charAt(i)));
            } else {
                map.put(s.charAt(i), ++t);
                sb.append(t);
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(isIsomorphic("abba", "abab"));
    }

}
