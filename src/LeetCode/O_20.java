package LeetCode;

import java.util.regex.Pattern;

/**
 * @description: 表示数字的字符串
 * @author: wang hao
 * @create: 2020-09-02 09:02
 */
public class O_20 {
    public boolean isNumber(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        boolean num = false;
        boolean point = false;
        boolean e = false;
        char[] chars = s.trim().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                num = true;
            } else if (c == '.') {
                // 之前不能出现.或者e
                if (point || e) {
                    return false;
                }
                point = true;
            } else if (c == 'e' || c == 'E') {
                // 之前不能出现e，之前必须有数字
                if (e || !num) {
                    return false;
                }
                e = true;
                num = false;//0E false
            } else if (c == '-' || c == '+') {
                // 只能在第一位，或者出现在e之后
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return num;
    }
/*    public boolean isNumber(String s) {
        String str="^[+|-]?((\\d+\\.?)|(\\d*\\.\\d+))([E|e][+|-]?\\d+)?$";
        return s.trim().matches(str);
    }*/
}
