package LeetCode;

import org.junit.Test;

/**
 * @description: 颠倒二进制位
 * @author: wang hao
 * @create: 2020-10-16 10:19
 */
public class _190 {
    public int reverseBits(int n) {
        int res = 0;
        // 0000000000...00100
        // 0010000000...00000
        for (int i = 0; i <= 31; i++) {
            // n & (1 << i) == 0 当前位为0，否则当前位为1
            if ((n & (1 << i)) != 0) {
                res ^= (1 << (31 - i));
            }
        }
        return res;
    }
    @Test
    public void test() {
        System.out.println(reverseBits(4));
    }
}
