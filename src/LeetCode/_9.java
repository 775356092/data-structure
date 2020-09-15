package LeetCode;

/**
 * @description: 回文数
 * @author: wang hao
 * @create: 2020-09-08 11:35
 */
public class _9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int y = 0;
        while (temp != 0) {
            y = y * 10 + temp % 10;
            temp /= 10;
        }
        return x == y;
    }
}
