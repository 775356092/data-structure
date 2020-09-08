package LeetCode;

/**
 * @description: 实现strStr()
 * @author: wang hao
 * @create: 2020-07-31 08:57
 */
public class _28 {
    /**
     * 实现 strStr() 函数。
     * <p>
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回-1。
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        for (int i = 0; i <= s.length - p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (s[i + j] != p[j]) {
                    break;
                }
                if (j == p.length - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
