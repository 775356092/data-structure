package LeetCode;

import org.junit.Test;

/**
 * @description: 两数相除
 * @author: wang hao
 * @create: 2020-09-24 14:29
 */
public class _29 {

    //-2147483648
    public int divide(int dividend, int divisor) {
        //true为正号，false为负号
        boolean sign = dividend > 0 == divisor > 0;
        int result = 0;
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        while (dividend <= divisor) {
            int t = divisor;
            int res = 1;
            while (dividend <= t << 1) {
                if (t < Integer.MIN_VALUE >> 1) {
                    break;
                }
                t = t << 1;
                res = res << 1;
            }
            dividend -= t;
            result += res;
        }
        if (sign) {
            if (result <= Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return sign ? result : -result;
    }

    @Test
    public void test() {
        System.out.println(divide(-10, 3));
        System.out.println(divide(-2147483648, -1));
    }
}
