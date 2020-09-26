package LeetCode;

import org.junit.Test;

/**
 * @description: 验证回文串
 * @author: wang hao
 * @create: 2020-09-22 17:09
 */
public class _125 {

    public boolean isPalindrome(String s) {
        return check(thin(s));
    }

    public String thin(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
            }
            if (Character.isDigit(c) || Character.isLetter(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public boolean check(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    @Test
    public void test() {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(isPalindrome("race a car"));
    }
}
