package LeetCode;

/**
 * @program: data-structure
 * @description: 最长回文字符串
 * @author: wang hao
 * @create: 2020-05-21 08:50
 */
public class _5 {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     */
    //动态规划dp[l][r] = dp[l+1][r-1] && s.charAt(l)==s.charAt(r)
    //dp[l][l] = true
    //dp[l][l+1] = s.charAt(l)==s.charAt(r)
    //时间复杂度O(n^2)
    public static String longestPalindrome(String s) {
        if (s.length() < 2 || s == null) {
            return s;
        }
        int left = 0;
        int right = 0;
        //最大长度
        int len = 1;
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > len) {
                        len = r - l + 1;
                        left = l;
                        right = r;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }

    //中心扩展法 遍历每个字符向外延申，直到到达边界或者两边的字符不相等（回文字符串长度为奇数）
    //如果回文字符串长度为偶数，就要找到字符串中含有两个字符的回文字符串向外延申
    //时间复杂度O(n^2)
    public static String longestStr(String s) {
        if (s.length() < 2 || s == null) {
            return s;
        }
        int left = 0;
        int right = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 + 1 > len) {
                    len = r - l + 1;
                    left = l;
                    right = r;
                }
                l--;
                r++;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                int l = i;
                int r = i + 1;
                while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 + 1 > len) {
                        len = r - l + 1;
                        left = l;
                        right = r;
                    }
                    l--;
                    r++;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    //中心扩展法，找以i，i-1为中心的偶数回文子序列，找以i-1，i+1为中心的奇数回文子序列
    public static String longest(String s) {
        if (s.length() < 2 || s == null) {
            return s;
        }
        int left = 0;
        int right = 0;
        int len = 0;
        for (int i = 1; i < s.length(); i++) {
            int l = i - 1;
            int r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    len = r - l + 1;
                    left = l;
                    right = r;
                }
                l--;
                r++;
            }
            l = i - 1;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    len = r - l + 1;
                    left = l;
                    right = r;
                }
                l--;
                r++;
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        String str = longest("aaaa");
        System.out.println(str);
    }
}
