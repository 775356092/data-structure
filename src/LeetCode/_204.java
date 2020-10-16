package LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 计算质数
 * @author: wang hao
 * @create: 2020-10-16 14:07
 */
public class _204 {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                res++;
                for (int j = 2; i * j < n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        long p = System.currentTimeMillis();
        System.out.println(countPrimes(150000000));
        System.out.println(System.currentTimeMillis() - p);
    }
}
