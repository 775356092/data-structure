package LeetCode;

import org.junit.Test;

/**
 * @description: 字符串转整数
 * @author: wang hao
 * @create: 2020-09-21 13:54
 */
public class O_67 {
    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        String s = str.trim();
        if (s == null || s.length() == 0) {
            return 0;
        }
        int mul = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //+，-，数字
            if (i == 0) {
                if (c == '+') {
                    continue;
                } else if (c == '-') {
                    mul = -1;
                    continue;
                } else if (Character.isDigit(c)) {
                    sb.append(c);
                    continue;
                } else {
                    return 0;
                }
            }
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                break;
            }
        }
        if (sb.length() == 0) {
            return 0;
        }
        long res = 0;
        String num = sb.toString();
        for (int i = 0; i < num.length(); i++) {
            res *= 10;
            res += num.charAt(i) - '0';
            long temp = res * mul;
            if (temp >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (temp <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) res * mul;
    }

    @Test
    public void test() {
        System.out.println(strToInt("20000000000000000000"));
        System.out.println(strToInt("-99999999999999999999999999999999"));
        System.out.println(strToInt(" +2147483641 test"));
        System.out.println(strToInt(" -2147483641 te st"));
    }
}
