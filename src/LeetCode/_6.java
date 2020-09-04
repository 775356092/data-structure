package LeetCode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @description: Z 字形变换
 * @author: wang hao
 * @create: 2020-07-17 10:20
 */
public class _6 {
    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * <p>
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * <p>
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * <p>
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     */


    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        ArrayList<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        //0 1 2 1 0 1 2
        int i = 0;
        boolean flag = true;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (flag) {
                i++;
                if (i == numRows - 1) {
                    flag = false;
                }
            } else {
                i--;
                if (i == 0) {
                    flag = true;
                }
            }

        }
        for (StringBuilder sb : rows) {
            res.append(sb.toString());
        }
        return res.toString();
    }

    @Test
    public void test() {
        System.out.println(convert("LEETCODEISHIRING", 3));
    }

}
