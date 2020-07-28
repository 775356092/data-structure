package LeeCode;

import java.net.CookieHandler;
import java.util.*;

/**
 * @program: data-structure
 * @description: 上升下降字符串
 * @author: wang hao
 * @create: 2020-05-14 10:36
 */
public class _1370 {
    /**
     * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
     * <p>
     * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
     * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
     * 重复步骤 2 ，直到你没法从 s 中选择字符。
     * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
     * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
     * 重复步骤 5 ，直到你没法从 s 中选择字符。
     * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
     * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
     * <p>
     * 请你返回将 s 中字符重新排序后的 结果字符串 。
     */
    public static String sortString(String s) {
        StringBuilder res = new StringBuilder();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        int len = s.length();
        while (len > 0) {
            for (Character c : map.keySet()) {
                if (map.get(c) > 0) {
                    res.append(c);
                    len--;
                    map.put(c, map.get(c) - 1);
                }
            }
            Set set = map.keySet();
            ArrayList<Character> list = new ArrayList<>(set);
            Collections.reverse(list);
            for (Character c : list) {
                if (map.get(c) > 0) {
                    res.append(c);
                    len--;
                    map.put(c, map.get(c) - 1);
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String string = sortString("spo");
        System.out.println(string);
    }
}
