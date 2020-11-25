package LeetCode;

/**
 * @description: 上升下降字符串
 * @author: wang hao
 * @create: 2020-11-25 09:10
 */
public class _1370 {
    public String sortString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        while (res.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    res.append((char) (i + 'a'));
                    count[i]--;
                }
            }
            for (int j = 25; j >= 0; j--) {
                if (count[j] > 0) {
                    res.append((char)(j + 'a'));
                    count[j]--;
                }
            }
        }
        return res.toString();
    }
}
