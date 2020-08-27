package LeetCode;

import java.util.ArrayList;

/**
 * @description: 千位分隔数
 * @author: wang hao
 * @create: 2020-08-26 17:24
 */
public class _1556 {
    public static String thousandSeparator(int n) {
        if (n >= 0 && n <= 999) {
            return n + "";
        }
        StringBuilder res = new StringBuilder(String.valueOf(n));
        String temp = res.toString();
        int len = temp.length();
        ArrayList<String> list = new ArrayList<>();
        for (; ; ) {
            if (len > 3) {
                list.add(res.substring(res.length() - 3, res.length()));
                res = new StringBuilder(res.substring(0, res.length() - 3));
                len -= 3;
            } else {
                list.add(res.toString());
                break;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            ans.append(list.get(i));
            ans.append(".");
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(thousandSeparator(1234));
    }
}
