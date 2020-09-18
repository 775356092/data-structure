package LeetCode;

import org.junit.Test;

/**
 * @description: Pow(x, n)
 * @author: wang hao
 * @create: 2020-09-15 15:19
 */
public class _50 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        double res = 1;
        long temp = n;
        if (temp < 0) {
            x = 1 / x;
            temp = -temp;
        }
        while (temp > 0) {
            if ((temp & 1) == 1) {
                res *= x;
            }
            x *= x;
            temp >>= 1;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(myPow(3, 12));
    }
}
