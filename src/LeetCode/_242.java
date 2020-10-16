package LeetCode;

import java.util.HashMap;

/**
 * @description: 有效的字母异位词
 * @author: wang hao
 * @create: 2020-10-16 15:35
 */
public class _242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                int x = map.get(c);
                if (x == 1) {
                    map.remove(c);
                } else {
                    map.put(c, x - 1);
                }
            }
        }
        return map.size() > 0;
    }
}
