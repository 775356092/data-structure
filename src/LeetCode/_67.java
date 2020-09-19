package LeetCode;

import org.junit.Test;

/**
 * @description: 二进制求和
 * @author: wang hao
 * @create: 2020-09-18 10:11
 */
public class _67 {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int k = 0;
        while (i >= 0 || j >= 0) {
            int x1 = 0;
            int x2 = 0;
            int temp = 0;
            if (i >= 0) {
                x1 = a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                x2 = b.charAt(j) - '0';
                j--;
            }
            if (x1 + x2 + k == 1 || x1 + x2 + k == 0) {
                temp = x1 + x2 + k;
                k = 0;
            } else if (x1 + x2 + k == 2) {
                k = 1;
                temp = 0;
            } else if (x1 + x2 + k == 3) {
                k = 1;
                temp = 1;
            }
            res.append(temp);
        }
        if (k == 1) {
            res.append(k);
        }
        return res.reverse().toString();
    }

    @Test
    public void test() {
        String s = addBinary("11", "1");
        System.out.println(s);
    }
}
