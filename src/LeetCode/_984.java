package LeetCode;

import org.junit.Test;

/**
 * @description: 不含AAA或BBB的字符串
 * @author: wang hao
 * @create: 2020-09-09 17:18
 */
public class _984 {
    public String strWithout3a3b(int A, int B) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        char curr = 'a';
        while (A > 0 || B > 0) {
            if (count == 2) {
                count = 0;
                if (curr == 'a') {
                    curr = 'b';
                    res.append('b');
                    B--;
                } else {
                    curr = 'a';
                    res.append('a');
                    A--;
                }
                continue;
            }
            if (A > B) {
                res.append('a');
                A--;
                count++;
                curr = 'a';
            } else {
                res.append('b');
                B--;
                count++;
                curr = 'b';
            }
        }
        return res.toString();
    }

    @Test
    public void test() {
        System.out.println(strWithout3a3b(4, 1));
    }

}
