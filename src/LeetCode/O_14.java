package LeetCode;

import org.junit.Test;

/**
 * @description: 剪绳子
 * @author: wang hao
 * @create: 2020-09-21 11:06
 */
public class O_14 {

    //动态规划 ，long溢出
    public long cuttingRope(int n) {
        long[] dp = new long[n + 1];
        //0,1不可拆分，从2开始
        for (int i = 2; i <= n; i++) {
            long temp = 0;
            for (int j = 1; j < i; j++) {
                temp = Math.max(temp, Math.max(j * dp[i - j], (i - j) * j));
            }
            dp[i] = temp;
        }
        return dp[n];
    }

    //尽可能多分出3
    public int cutRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        long res = 1;
        //n=5,拆分成3和2；n=4,拆分成2和2；
        while (n > 4) {
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }

    @Test
    public void test() {
        System.out.println(cutRope(120));
    }

}
