package LeetCode;

import org.junit.Test;

/**
 * @description: 排列硬币
 * @author: wang hao
 * @create: 2020-10-21 11:47
 */
public class _441 {
    public int arrangeCoins(int n) {
        int res = 1;
        long t = 0;
        while (t < n) {
            t += res;
            res ++;
        }
        return t == n ? res - 1 : res - 2;
    }

    @Test
    public void test() {
        System.out.println(arrangeCoins(2147483647));
    }
}
