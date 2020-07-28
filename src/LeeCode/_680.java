package LeeCode;

/**
 * @program: data-structure
 * @description: 验证回文字符串 II
 * @author: wang hao
 * @create: 2020-05-19 09:02
 */
public class _680 {
    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     * 字符串只包含a-z的小写字母
     */
    // abca
    public boolean validPalindrome(String s) {
        if (isValid(s)) {
            return true;
        } else if (validPalindromeDeleteOneChar(s)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validPalindromeDeleteOneChar(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isValid(s.substring(left + 1, right + 1)) || isValid(s.substring(left, right));
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isValid(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    public static boolean isValids(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValids("abbccbba"));
    }

}