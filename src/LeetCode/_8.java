package LeetCode;

/**
 * @description: 字符串转换整数
 * @author: wang hao
 * @create: 2020-08-31 10:20
 */
public class _8 {
    public static int myAtoi(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int mul = 1;
        StringBuilder temp = new StringBuilder();
        //第一个字符只能是数字或者是负号
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                if (chars[i] == '-') {
                    mul = -1;
                    continue;
                }
                if (chars[i] == '+') {
                    continue;
                }
                if (Character.isDigit(chars[i])) {
                    temp.append(chars[i]);
                } else {
                    return 0;
                }
            }
            if (i > 0 && Character.isDigit(chars[i])) {
                temp.append(chars[i]);
            }
            if (!Character.isDigit(chars[i])) {
                break;
            }
        }
        if (temp.length() == 0) {
            return 0;
        }
        double v = Double.parseDouble(temp.toString()) * mul;
        if (v >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (v <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return mul * Integer.parseInt(temp.toString());
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-"));
    }

}
