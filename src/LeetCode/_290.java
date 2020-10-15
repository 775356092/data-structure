package LeetCode;

import org.junit.Test;

import java.util.HashMap;

/**
 * @description: 单词规律
 * @author: wang hao
 * @create: 2020-10-15 16:42
 */
public class _290 {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char t = pattern.charAt(i);
            if (map.containsKey(t)) {
                if (!map.get(t).equals(arr[i])) {
                    return false;
                }
            } else {
                map.put(t, arr[i]);
                if (map2.containsKey(arr[i]) && !map2.get(arr[i]).equals(t)) {
                    return false;
                } else {
                    map2.put(arr[i], t);
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(wordPattern("abba", "cat bat bat cat"));
        System.out.println(wordPattern("abba", "cat cat cat cat"));
    }
}
