package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 查找常用字符串
 * @author: wang hao
 * @create: 2020-10-14 09:08
 */
public class _1002 {
    public List<String> commonChars(String[] A) {
        int[] x = new int[26];
        Arrays.fill(x, (int) 1e6);
        for (String s : A) {
            int[] t = new int[26];
            for (int i = 0; i < s.length(); i++) {
                t[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                x[i] = Math.min(x[i], t[i]);
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < x[i]; j++) {
                res.add("" + (char) (i + 97));
            }
        }
        return res;
    }
}
