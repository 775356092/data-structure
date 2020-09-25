package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 串联所有单词的子串
 * @author: wang hao
 * @create: 2020-09-25 13:06
 */
public class _30 {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int wordLen = words[0].length();
        int len = 0;
        for (String s1 : words) {
            len += s1.length();
            map.put(s1, map.getOrDefault(s1, 0) + 1);
        }
        for (int i = 0; i <= s.length() - len; i++) {
            if (check(s.substring(i, i + len), map, wordLen)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean check(String s, HashMap<String, Integer> map, int wordLen) {
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i <= s.length() - wordLen; i += wordLen) {
            String t = s.substring(i, i + wordLen);
            if (!map.containsKey(t)) {
                return false;
            }
            map1.put(t, map1.getOrDefault(t, 0) + 1);
            if (map1.get(t) > map.get(t)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }
}
