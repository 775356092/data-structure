package LeetCode;

import org.junit.Test;

/**
 * @description: Excel表列名称
 * @author: wang hao
 * @create: 2020-09-30 13:49
 */
public class _168 {
    // 10进制转26进制
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            n -= 1;
            res.append((char) ('A' + n % 26));
            n /= 26;
        }
        return res.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(convertToTitle(701));
    }
}
