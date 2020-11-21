package LeetCode;

import org.junit.Test;

/**
 * @description: 分数到小数
 * @author: wang hao
 * @create: 2020-11-05 17:28
 */
public class _166 {
    public String fractionToDecimal(int a, int b) {
        double t = a / (double) b;
        return String.valueOf(t);
    }

    @Test
    public void test() {
        System.out.println(fractionToDecimal(4, 333));
    }
}
