package LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 加一
 * @author: wang hao
 * @create: 2020-09-08 10:28
 */
public class _66 {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[len + 1];
            res[0] = 1;
            return res;
        }
        return null;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,8})));
    }
}
